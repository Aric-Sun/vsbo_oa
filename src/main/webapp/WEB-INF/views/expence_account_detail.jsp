<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 报销单详情 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 基本信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">事由</div>
                        <div class="col-md-6">${expenceAccountMap.cause}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">创建人</div>
                        <div class="col-md-4">${expenceAccountMap.createrName}</div>
                        <div class="col-md-2">创建时间</div>
                        <div class="col-md-4">
                            <fmt:formatDate type="time" value="${expenceAccountMap.create_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
<%--                            ${expenceAccountMap.create_time}--%>
                        </div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">待处理人</div>
                        <div class="col-md-4">${expenceAccountMap.nextHandlerName}</div>
                        <div class="col-md-2">状态</div>
                        <div class="col-md-4">${expenceAccountMap.status}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 费用明细 </span>
                    </div>
                    <div class="section row">
                        <c:forEach items="${expenceDetails}" var="detail">
                            <div class="col-md-3">${detail.type}</div>
                            <div class="col-md-3">${detail.money}</div>
                            <div class="col-md-5">${detail.description}</div>
                        </c:forEach>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">总金额</div>
                        <div class="col-md-6">${expenceAccountMap.total_money}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 处理流程 </span>
                    </div>
                    <div class="section row">
                        <c:forEach items="${records}" var="record">
                            <div class="col-md-1">${record.ename}</div>
                            <div class="col-md-3">${record.recordTime}</div>
                            <div class="col-md-1">${record.recordType}</div>
                            <div class="col-md-2">${record.recordResult}</div>
                            <div class="col-md-5">备注：${record.comment}</div>
                        </c:forEach>
                    </div>
                    <div class="panel-footer text-right">
                        <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="bottom.jsp"/>
