/**
 * Created by zevik on 12/29/2017.
 */
$(document).ready(function ()
{
    $("#b1").click(function () {

        var i = $("#hotel_id").val();
        var n = $("#hotel_name").val();
        var d = $("#hotel_description").val();
        var c = $("#hotel_city").val();
        var r = $("#hotel_rating").val();
        console.log('1')

        var data_send= {id:i,name: n , description: d,city: c , rating: r}
        console.log(JSON.stringify(data_send))

        $.ajax({
            type: 'PUT',
            url: '/hotels',
            contentType : 'application/json',

            data: JSON.stringify(data_send),
            success: function (data) {
                console.log(data)
                if (data==true)
                {
                    alert('Changed Succsesfully! check your DB !')
                }
                else
                {
                    alert('Changed Not Succsesfully !')
                }

            }

        });


    })
})