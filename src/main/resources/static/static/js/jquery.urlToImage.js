
(function($){
    $.fn.urlToImage = function(options) {
        var options = $.extend({}, $.fn.urlToImage.defaults, options); 
        return this.each(function(){
            $(this).html( $(this).html().replace( /([-a-zA-Z0-9@:%_\+.~#?&//=]{2,256}\.[a-z]{2,4}\b(\/[-a-zA-Z0-9@:%_\+.~#?&//=]*)?(?:jpg|jpeg|gif|png))/gi,'<a href="$1" target="'+options.target+'"><img class="sml" src="$1" /></a><br />') );
        });
    }
    /**
     * Default configuration
     */
    $.fn.urlToImage.defaults = {
        target : '_blank'        // Link target
    }
})(jQuery)