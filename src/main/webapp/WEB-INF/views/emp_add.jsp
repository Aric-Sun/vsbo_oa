<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 添加员工 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form action="/oa/addEmp.do" id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                工号：
                                <label class="field prepend-icon">
                                    <input name="eId" class="gui-input" placeholder="工号..." />
                                    <label class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                姓名：
                                <label class="field prepend-icon">
                                    <input name="ename" class="gui-input" placeholder="姓名..."/>
                                    <label  class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                部门：
                                <label class="field select">
                                    <select name="dId" itemLabel="name"  class="gui-input" placeholder="所属部门...">
                                        <c:forEach items="${depts}" var="dept">
                                            <option value="${dept.dId}">${dept.dName}</option>
                                        </c:forEach>
                                    </select>
                                    <i class="arrow double"></i>
                                </label>
                            </div>
                            <div class="col-md-6">
                                职务：
                                <label class="field select">
                                    <select name="job" class="gui-input" placeholder="职务...">
                                        <c:forEach var="job" items="${jobs}">
                                            <option value="${job}">${job}</option>
                                        </c:forEach>

                                    </select>
                                    <i class="arrow double"></i>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>