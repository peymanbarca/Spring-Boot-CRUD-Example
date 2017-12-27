/**
 * Created by zevik on 12/19/2017.
 */
$(document).ready(function ()
{
    $("#b1").click(function () {
        $.get("/hotels",function (data)
        {
            console.log(data)


        })
    })


    $("#b2").click(function () {
        var id=$('#input_id').val();
        $.get("/hotels/"+String(id),function (data,err)
        {
            if (data!=null)
            {
                alert('Found sucssesfully! ' + ' name : '+ String(data.name) + ' city : ' + String(data.city)
                    + ' id : ' + String(data.id))

            }
            console.log(data)


         }).fail(function(){
            alert('Not Found!')
        });
    })

    $("#b3").click(function () {
        // $.post("/hotels",{name: $("#hotel_name").val() , description: $("#hotel_description").val(),
        //     city: $("#hotel_city").val() , rating: $("#hotel_rating").val()}
        //     ,function (data)
        // {
        //     console.log(data)
        //
        //
        // })
        var n = $("#hotel_name").val();
        var d = $("#hotel_description").val();
        var c = $("#hotel_city").val();
        var r = $("#hotel_rating").val();
        console.log('1')

        var data_send= {name: n , description: d,city: c , rating: r}
        console.log(JSON.stringify(data_send))

            $.ajax({
                type: 'POST',
                url: '/hotels',
                contentType : 'application/json',

                data: JSON.stringify(data_send),
                success: function (data) {
                    console.log(data)
                    if (data==true)
                    {
                        alert('Created Succsesfully! check your DB !')
                    }
                    else
                    {
                        alert('Created Not Succsesfully !')
                    }

                }

            });





    })


})
