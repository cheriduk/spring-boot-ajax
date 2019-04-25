$(function(){
    $('.btn').click(function(){
        alert("jms");
        var id = new Date().getDate() + "" + new Date().getMinutes();
        var from = $('input[name="from"]').val();
        var to = $('input[name="to"]').val();
        var text = $('textarea[name="text"]').val();
        var time = new Date().getTime();
        var url = "/send";
        var args = {"id": id, "from": from, "to": to, "text": text, "time": time};
        $.post(url, args, function(data){
            $('input[name="from"]').val("");
            $('input[name="to"]').val("");
            $('textarea[name="text"]').val("");
            alert(data);
        });
    });
});