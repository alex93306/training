<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 29.04.2015
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <sec:csrfMetaTags/>
    <style>
        #fileupload {
            display: none;
        }
.imageBox {
    padding: 10px;
    border: 1px solid #ddd;
    height: 150px;
    width: 150px;
}
        .progress-bar {
            height: 18px;
            background: green;
        }
    </style>
</head>
<body>

<div class="avatarBox">
    <div class="imageBox">
        <img id="avatar" src=""/>
    </div>
    <div class="files" id="files">

    </div>
    </div>

    <div class="actionBar">

        <input id="fileupload" type="file" name="files[]">
        <button id="changeImg" type="button">Change</button>
        <button id="deleteImg" type="button">Delete</button>
    </div>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="/resources/js/vendor/jquery.ui.widget.js"></script>
<script src="/resources/js/jquery.iframe-transport.js"></script>
<script src="/resources/js/jquery.fileupload.js"></script>
<%--<script>
    $(function() {
        $('fileupload').fileupload(
                {
                    url: '/file',
                    dataType: 'json',
                    autoUpload: true,
                    add: function(e, data) {
                        data.submit();
                    },
                    done: function(e, data) {
                        $.each(data.result.files, function(index, file) {
                            $('#avatar').src=file.thumbnailUrl;
                        })
                    },
                    progress: function (e, data) {
                        var progress = parseInt(data.loaded / data.total * 100, 10);
                        $('#progress .bar').css(
                                'width',
                                progress + '%'
                        );
                    }

                }
        )
    });
</script>--%>
<script>
    $(function () {
        'use strict';
        // Change this to the location of your server-side upload handler:
        var url = '/file';

        var avatar=$('#avatar');
        $('#fileupload').fileupload({
            url: url,
            dataType: 'json',
            maxNumberOfFiles: 1,
            submit: function(e, data) {
//                avatar.attr('src', '/resources/img/loading.gif');
                avatar.parent().css("background", "url('/resources/img/loading.gif') 50% 50%/ 50px 50px no-repeat");
            },

            done: function (e, data) {
                $.each(data.result.files, function (index, file) {
                    $('#avatar').attr('src', file.thumbnailUrl);

                });
            }

        }).prop('disabled', !$.support.fileInput)
                .parent().addClass($.support.fileInput ? undefined : 'disabled');

        $('#changeImg').click(function() {
            $('#fileupload').click();
        });
        $('#deleteImg').click(function() {
            var conf=confirm('Вы уверены что хотите удалить фото?');
            if(conf) {
                $.ajax({
                    url: '/profile/image/delete',
                    success: function(result) {
                        $('#avatar').attr('src', '');
                    }
                });


            }

        })
    });
</script>
</body>
</html>
