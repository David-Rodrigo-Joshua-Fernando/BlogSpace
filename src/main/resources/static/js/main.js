$(function(){
    $(".editButton").click(function(event){
        window.location.replace(`/blogs/${$(this).attr("data-id")}/edit`)
    });

    $(".deleteButton").click(function(event){
        window.location.replace(`/blogs/${$(this).attr("data-id")}/delete`)
    });
})