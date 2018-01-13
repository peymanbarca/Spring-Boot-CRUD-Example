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
                txt+="<tr><td> " + "Id" + "</td><td>  " + "City" + "</td>" +
                    "<td>  " + "Description" + "</td>  " + "<td>" + "Name" + "</td>" +
                    "<td>" + "Rating" + "</td>" + "<td>" + "PassengerId" + "</td>" + "</tr>";
                if (len > 0) {
                    butons=[]
                    for (var i = 0; i < len; i++) {
                        if (data.content[i].id && data.content[i].city) {
                            txt += "<tr><td>  " + data.content[i].id + "</td><td>  " + data.content[i].city + "</td>  " +
                                "<td>  " + data.content[i].description + "</td>  " + "<td>" + data.content[i].name + "</td>" +
                                "<td>  " + data.content[i].rating + "</td>"  +"<td>" + data.content[i].psg_id + "</td> " + "<td>"+
                                "<a href='../html/update_from.html'>Edit</a>"
                            + "<td>  " + "<td>  " + "<button id='b_" + String(i) + "'>Delete</button>" + "<td>" + "</tr>";
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




    $("#b5").click(function () {
        $.get("/passengers",function (data)
        {
            $("#table2").html("")
            console.log(data)
            if(data.content)
            {
                var len = data.content.length;
                console.log(len)
                var txt = "";
                txt+="<tr><td> " + "Id" + "</td><td>  " + "First Name" + "</td>" +
                    "<td>" + "Last Name" + "</td>" + "<td>" + "City" +
                     "</td>" + "</tr>";
                if (len > 0) {
                    for (var i = 0; i < len; i++) {
                        if (data.content[i].id) {
                            txt += "<tr><td> " + data.content[i].id + "</td><td>  " + data.content[i].first_name + "</td>" +
                                "<td>  " + data.content[i].last_name + "</td>  " + "<td>" + data.content[i].city +
                             "<td>" + "</tr>";

                        }

                    }
                    if (txt != "") {
                        $("#table2").append(txt).removeClass("hidden2");
                    }


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
            alert('Hotel Not Found!')
        });
    })

    $("#b_2").click(function () {
        var id=$('#input_id2').val();
        $.get("/hotels/getPsg/"+String(id),function (data,err)
        {
            if (data!=null && data.id)
            {
                alert('Found sucssesfully! ' + ' first_name : '+ String(data.first_name) + ' last_name : ' + String(data.last_name)
                    + ' id : ' + String(data.id) +  ' city : ' + data.city)

            }

            else
            {
                alert('This is an empty Hotel ...')

            }
            console.log(data)


        }).fail(function(){
            alert('Hotel Not Found!')
        });
    })

    $("#b3").click(function () {

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

    //////////////////////////////////////////////////

    $("#b4").click(function () {

        var f = $("#first_name").val();
        var l = $("#last_name").val();
        var c = $("#psg_city").val();
        console.log('1')

        var current_timestamp2 = new Date();

        var t = $("#psg_enter").val();
        console.log(t)

        if (t!= undefined)
        {
            var data_send = {first_name: f, last_name: l, city: c, enterdate: current_timestamp2}
            console.log(JSON.stringify(data_send))
        }

        else {
            var data_send = {first_name: f, last_name: l, city: c}
            console.log(JSON.stringify(data_send))
        }







        // $.ajax({
        //     type: 'POST',
        //     url: '/passengers',
        //     contentType : 'application/json',
        //
        //     data: JSON.stringify(data_send),
        //     success: function (data) {
        //         console.log(data)
        //         if (data==true)
        //         {
        //             alert('Passenger has been Created Succsesfully! check your DB !')
        //         }
        //         else
        //         {
        //             alert('Created Not Succsesfully , Try again !')
        //         }
        //
        //     }
        //
        // });
    })


})
