<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 填写报销单 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form id="admin-form" name="addForm" action="/oa/addExpence.do" modelAttribute="info">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section">
                            事由:
                            <label class="field prepend-icon">
                                <input name="expenceAccount.cause" class="gui-input" placeholder="事由..."/>
                                <label  class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>
                        <div class="section-divider mt20 mb40">
                            <span> 费用明细 </span>
                        </div>
                        <div class="section row" id="items">
                            <div>
                                <div class="col-md-3">
                                    <label  class="field prepend-icon">
                                        <select name="type" class="gui-input" placeholder="花销类型...">
                                            <c:forEach var="item" items="${items}">
                                                <option value="${item}">${item}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </div>

                                <div class="col-md-3">
                                    <label class="field prepend-icon">
                                        <input name="money" class="gui-input money" placeholder="金额..."/>
                                        <label  class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>

                                <div class="col-md-5">
                                    <label  class="field prepend-icon">
                                        <input name="description" class="gui-input" placeholder="备注..." />
                                        <label  class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-1" style="text-align:right;">
                                    <button type="button" class="button"> X </button>
                                </div>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-3">
                                <label  class="field prepend-icon">
                                    <input id="totalMoney" name="expenceAccount.totalMoney" class="gui-input" placeholder="总金额..." readonly="true"/>
                                    <label class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section" style="text-align:right;">
                                <div class="col-md-9">
                                    <button type="button" class="button" id="addItemButton"> + </button>
                                </div>
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