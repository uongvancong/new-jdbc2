<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sach bai viet</title>
    </head>

    <body>
        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-sate" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#">Trang Chủ</a>
                        </li>
                    </ul>
                </div>
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive"></div>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td>cong</td>
                                        <td>uong</td>
                                        <td>cong.uv@gmail.com</td>
                                    </tr>
                                    <tr>
                                        <td>cong</td>
                                        <td>uong</td>
                                        <td>cong.uv@gmail.com</td>
                                    </tr>
                                    <tr>
                                        <td>cong</td>
                                        <td>uong</td>
                                        <td>cong.uv@gmail.com</td>
                                    </tr>
                                </tbody>

                            </table>
                            <ul class="pagination" id="pagination"></ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function() {
                window.pagObj = $('#pagination').twbsPagination({
                    totalPages: 10,
                    visiblePages: 5,
                    onPageClick: function(event, page) {
                        console.info(page + ' (from options)');
                    }
                }).on('page', function(event, page) {
                    console.info(page + ' (from event listening)');
                });
            });
        </script>
    </body>

    </html>