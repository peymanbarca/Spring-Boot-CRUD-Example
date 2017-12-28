/**
 * Created by zevik on 12/19/2017.
 */
$(document).ready(function ()
{
    $("#b1").click(function () {
        $.get("/hotels",function (data)
        {
            $("#table").html("")
            console.log(data)
            if(data.content)
            {
                var len = data.content.length;
                console.log(len)
                var txt = "";
                if (len > 0) {
                    butons=[]
                    for (var i = 0; i < len; i++) {
                        if (data.content[i].id && data.content[i].city) {
                            txt += "<tr><td>" + data.content[i].id + "</td><td>" + data.content[i].city + "</td>" +
                                "<td>" + data.content[i].description + "</td>" + "<td>" + data.content[i].name + "</td>" +
                                "<td>" + data.content[i].rating + "</td>" + "<td>" +"<a href='../html/update_from.html'>Edit</a>"
                            + "<td>" + "<td>" + "<button id='b_" + String(i) + "'>Delete</button>" + "<td>" + "</tr>";
                            butons.push({i:"b"+String(i)})
                        }

                    }
                    if (txt != "") {
                        $("#table").append(txt).removeClass("hidden");
                    }


                }

                function createCallback( i ){
                    return function()
                    {
                        var id_delete= data.content[i].id
                        console.log('delete!' + String(id_delete))

                        $.ajax({
                            type: 'DELETE',
                            url: '/hotels/'+String(id_delete),
                            contentType : 'application/json',


                            success: function (data) {
                                console.log(data)
                                if (data==true)
                                {
                                    alert('deleted Succsesfully! check your DB !')
                                }
                                else
                                {
                                    alert('deleted Not Succsesfully !')
                                }

                            }

                        });

                    }
                }

                for (var i = 0; i < butons.length; i++)
                {

                    $("#b_"+String(i)).click(createCallback( i ));


                }



            }






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
