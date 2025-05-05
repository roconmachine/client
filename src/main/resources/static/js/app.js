

    $(document).ready(function() {
        $('.line-input').focus(function() {
            $(this).css('border-bottom-color', '#007bff'); // Change line color
        }).blur(function() {
            $(this).css('border-bottom-color', '#333'); // Revert line color
        });
    });



function notImplemented(node){
    alert("This feature is not yet implemented. We will implement soon.");
}

function packageUpdate(){
    $("#packageName").val($("#group").val() + "."+  $("#artifact").val());
}