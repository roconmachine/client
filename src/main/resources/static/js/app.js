

    $(document).ready(function() {
        $('.line-input').focus(function() {
            $(this).css('border-bottom-color', '#007bff'); // Change line color
        }).blur(function() {
            $(this).css('border-bottom-color', '#333'); // Revert line color
        });
    });
