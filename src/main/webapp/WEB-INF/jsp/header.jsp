<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KSHRD Home</title>
	<!--set unicode for font page-->
    <meta charset="utf-8">
    <!--set for responsive layout view-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--set icon for page-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/static/images/favicon_1.ico">
    <!--set title of page-->
    <title>School System MGR</title>
    <!--Display morris chart-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/plugins/morris/morris.css">
    <!--default boostrap style -->
    <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!--control on custom boostrap, animation, layout menu...-->
    <link href="${pageContext.request.contextPath}/resources/static/css/core.css" rel="stylesheet" type="text/css" />
    <!--makeup control form like button, checkbox, radio...-->
    <link href="${pageContext.request.contextPath}/resources/static/css/components.css" rel="stylesheet" type="text/css" />
    <!--makeup icon like fa, md...-->
    <link href="${pageContext.request.contextPath}/resources/static/css/icons.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/resources/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/static/js/modernizr.min.js"></script>
</head>
<body class="fixed-left">
	<!-- === wrapper of header and left menu AND all content === -->
    <div id="wrapper">
        <!-- ==== header ====-->
        <div class="topbar">
            <div class="topbar-left">
                <div class="text-center">
                    <a href="index.html" class="logo"><i class="icon-magnet icon-c-logo"></i><span>School system</span></a>
                </div>
            </div>
            <div class="navbar navbar-default" role="navigation">
                <div class="container">
                    <div class="">
                        <div class="pull-left">
                            <button class="button-menu-mobile open-left">
                                <i class="ion-navicon"></i>
                            </button>
                            <span class="clearfix"></span>
                        </div>

                        <form role="search" class="navbar-left app-search pull-left hidden-xs">
                            <input type="text" style="background-color: white; color: black" placeholder="Search..." class="form-control">
                            <a href="#"><i class="fa fa-search"></i></a>
                        </form>

                        <ul class="nav navbar-nav navbar-right pull-right">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle profile" data-toggle="dropdown" aria-expanded="true"><img src="assets/images/users/avatar-1.jpg" alt="user-img" class="img-circle"> </a>
                                <ul class="dropdown-menu">
                                    <li><a href="javascript:void(0)"><i class="ti-user m-r-5"></i> Profile</a></li>
                                    <li><a href="javascript:void(0)"><i class="ti-settings m-r-5"></i> Settings</a></li>
                                    <li><a href="javascript:void(0)"><i class="ti-lock m-r-5"></i> Lock screen</a></li>
                                    <li><a href="javascript:void(0)"><i class="ti-power-off m-r-5"></i> Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- ==== end header ====-->
        <!-- ========== menu ========== -->
        <div class="left side-menu">
            <div class="sidebar-inner slimscrollleft">
                <div id="sidebar-menu">
                    <ul>
                        <!--<li class="text-muted menu-title">Navigation</li>-->
                        <li>
                            <a href="index.php" class="waves-effect active"><i class="ti-home"></i> <span> Dashboard </span> </a>
                        </li>
                        <li class="has_sub">
                            <a href="#" class="waves-effect"><i class="ti-pencil-alt"></i><span>Study Management</span></a>
                            <ul class="list-unstyled">
                                <li><a href="generation.php"><i class="fa fa-institution"></i>Generation</a></li>
                                <li><a href="course.php"><i class="fa fa-mortar-board "></i>Course</a></li>
                                <li><a href="class.php"><i class="fa fa-sitemap"></i>Class</a></li>
                                <li><a href="subject.php"><i class="fa fa-trophy"></i>Subject</a></li>

                            </ul>
                        </li>
                        <li class="has_sub">
                            <a href="#" class="waves-effect"><i class="fa fa-graduation-cap"></i> <span> Student </span> </a>
                            <ul class="list-unstyled">
                                <li><a href="new_student.php"><i class="fa fa-plus-square"></i>Register</a></li>
                                <li><a href="student_list.html"><i class="fa fa-list-alt"></i>Student List</a></li>
                            </ul>
                        </li>
                        <li class="has_sub">
                            <a href="#" class="waves-effect"><i class="md  md-people"></i><span> Instructor </span> </a>
                            <ul class="list-unstyled">
                                <li><a href="components-grid.html"><i class="fa fa-plus-circle"></i>New Instructor</a></li>
                                <li><a href="components-widgets.html"><i class="fa fa-bars"></i>Instructor List</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="subject.html" class="waves-effect"><i class="fa fa-book"></i> <span> Course </span> </a>
                        </li>
                        <li>
                            <a href="user.html" class="waves-effect"><i class="fa fa-user"></i> <span> User </span> </a>
                        </li><hr>
                        <li><a href="ui-portlets.html"><i class="fa fa-check-square-o"></i>Attendance</a></li>
                        <li><a href="score.html"><i class="fa fa-adn"></i>Score</a></li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- ========== end menu ========== -->
