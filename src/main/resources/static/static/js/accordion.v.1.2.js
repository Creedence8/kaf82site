/*
* Версия 1.3
* Добавлена возможность программно отрывать/закрывать панели
* ВНИМАНИЕ! Если установленный пользователем обработчик onBeforeOpen ЯВНО не вернёт true - ПАНЕЛЬКА НЕ ОТКРОЕТСЯ!
* А если onBeforeCollapse ЯВНО не вернёт true - закрытая панелька не закроется (а другие не смогут открыться)
*/
var Accordion = (function (GLOB) {
	"use strict";
	// Анимация свёртывания панели:
	function collapse(element, ctx) {
		var i = element.dd.scrollHeight,
			intId;
        // Вызываем обработчик события "до свёртывангия панели"
        if (!ctx.cfg.onBeforeCollapse(element)) {
            return false;
        }
        intId = GLOB.setInterval(
            function () {
                if ((i -= ctx.cfg.speed) <= 0) {
                    element.dd.style.height = "0px";
                    GLOB.clearInterval(intId);
                    // Изменяем состояние объекта:                        
                    // Вызываем обработчик события "после свёртывангия панели"
                    ctx.cfg.onAfterCollapse(element);
                    return true;
                }
                element.dd.style.height = i + "px";
                return true;
            },
            5
        );
        element.dt.removeAttribute("id");
        element.state = 0;
        return true;
	}
	// Анимация развёртывания панели:
	function expand(element, ctx) {
		var i       = 0,
            height  = element.dd.scrollHeight,
            intId;
        // Вызываем обработчик события "до открытия панели"
        if (!ctx.cfg.onBeforeOpen(element)) {
            return false;
        }
        intId   = GLOB.setInterval(
            function () {
                if ((i += ctx.cfg.speed) >= height) {
                    element.dd.style.height = height + "px";
                    GLOB.clearInterval(intId);
                    // Изменяем состояние объекта:
                    // Вызываем обработчик события "после открытия панели"
                    ctx.cfg.onAfterOpen(element);
                    return true;
                }
                element.dd.style.height = i + "px";
                return true;
            },
            5
        );
        element.dt.id = ctx.prefix + "-current";
        element.state = 1;
        return true;
	}
    /**
     * Возвращаемая ф-ция
     * @param HTMLElement element - элемент для создания панелек,
     * @param Object config - объект конфигурации.
     */
	return function (element, config) {
        return {
            // Объект конфигурации:
			cfg			: {
                // Заранее открытая панелька:
				openIdx	: 0,
                // Скорость открытия/закрытия
				speed	: 5,
                // Тип события на которое будем реагировать.
				event	: "click",
                // Обработчик вызывается ПЕРЕД ОТКРЫТИЕМ панельки el-HTMLElement - текущая панелька
                onBeforeOpen:   function (el) {return true; },
                // Обработчик вызывается ПОСЛЕ ОТКРЫТИЯ панельки el-HTMLElement - текущая панелька
                onAfterOpen:    function (el) {return true; },
                // Обработчик вызывается ПЕРЕД ЗАКРЫТИЕМ панельки el-HTMLElement - текущая панелька
                onBeforeCollapse:   function (el) {return true; },
                // Обработчик вызывается ПОСЛЕ ЗАКРЫТИЯ панельки el-HTMLElement - текущая панелька
                onAfterCollapse:    function (el) {return true; }
			},
			// Метод для "перегона" свойств из объекта - параметра конфигурации во внутренний объект
			option		: function (config) {
				var p;
				for (p in config) {
					// Здесь JSLint будет брехать - игнорим!
					if (this.cfg.hasOwnProperty(p)) {
						this.cfg[p] = typeof config[p] === "undefined" ? this.cfg[p] : config[p];
					}
				}
				return true;
			},
            // Массив ссылок на объекты - панельки
            panes : [],
            // Ссылка на объект - открытую панельку
            opened : null,
            // Префикс стилей
            prefix : null,
            // Инициализация объекта - вызывается автоматом сразу.
			init	: function (element, config) {
				var panes	= element.children,
					length	= panes.length,
					ctx = this,
					cur,
					i;
                // Задаём конфигурацию:
				ctx.option(config);
                this.prefix	= element.id;
                // Обработчик вынесен в эту ф-цию, что бы не навешивать его внутри цикла:
				function actionHandler(current) {
                    ctx.panes.push(current);
                    // Вешаем обработчики (помним: событие задаётся в настройках ctx.cfg.event):
					current.dt["on" + ctx.cfg.event] = function () {
						// Если кликнули на новой панельке - Меняем ссылку на текущий объект:
						if (ctx.opened !== current) {
							// Если ctx.opened назначен вообще:	
							if (ctx.opened && ctx.opened.state === 1) {
                                if (!collapse(ctx.opened, ctx)) {
                                    return false;
								}
							}
							ctx.opened = current;
							expand(ctx.opened, ctx);
							return true;
						}
						// Текущий объект в состоянии "ЗАКРЫТ" - Открываем:
						if (current.state === 0) {
							if (!expand(ctx.opened, ctx)) {
                                return false;
							}
							return true;
						}
						// Текущий объект в состоянии "ОТКРЫТ" - Закрываем:
						collapse(ctx.opened, ctx);
						return true;
					};
					return true;
				}
                // Пройдёмся по всем четным! панелькам, развесим на них обработчики:
				for (i = 0; i < length; i += 2) {
                    // Этот объект будет представлять текущее состояние
                    // на момент прохода цикла.
					cur = {
                        // Элемент - заголовок
						dt : panes[i],
                        // Элемент - тело
						dd : panes[i + 1],
                        // Номер панельки:
                        num : (i / 2) + 1,
                        // Состояние (учитывая настройки ставим закрыто 0/открыто 1)
						state : (i === ((ctx.cfg.openIdx - 1) * 2)) ? 1 : 0
					};
                    // Если сотояние текущего объекта открыто:
					if (cur.state === 1) {
						ctx.opened			= cur;
						ctx.opened.dt.id	= this.prefix + "-current";
					} else {
						cur.dd.style.height	= "0px";
					}
					cur.dd.style.overflow	= "hidden";
					actionHandler(cur);
				}
				return this;
			},
            /**
             * Программно закрыть открытую панельку
             * @return bool
             */
            close : function () {
                // Если не существует открытый объект, или его состояние "закрыт"
                if (!this.opened || this.opened.state === 0) {
                    return false;
                }
                collapse(this.opened, this);
                return true;
            },
            /**
             * Программно закрыть открытую панельку и открыть paneNum - панельку:
             * @param int: paneNum - номер панельки, которую нужно открыть
             * @return bool
             */
            open  : function (paneNum) {
                // Если панельки с указанным индексом - не существует:
                if (!this.panes[paneNum]) {
                    return false;
                }
                // Если указанный объект == текущему и у текущего состояние "открыт"
                if (this.opened && this.opened.state === 1 && this.panes[paneNum].num === this.opened.num) {
                    return true;
                }
                // Если существует открытый объект, и его состояние "открыт"
                if (this.opened && this.opened.state === 1) {
                    // Закрываем его:
                    if (!collapse(this.opened, this)) {
                        return false;
                    }
                }
                // Открываем указанную панельку:
                if (!expand(this.panes[paneNum], this)) {
                    return false;
                }
                // Меняем ссылку на открытый объект:
                this.opened = this.panes[paneNum];
                return true;
            }
		}.init(element, config);
	};
}(this));