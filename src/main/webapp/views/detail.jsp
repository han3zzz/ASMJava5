<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <br>
   <div class="container" >
    <div class="row">
        <div class="col-md-6">
            <div id="carouselExampleIndicators" class="carousel slide detail-giantrai" data-ride="carousel">
                <ol class="carousel-indicators">
                  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="carousel-item active anhsp-detail">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/views/img/${p.anh}" alt="First slide">
                  </div>
                  <div class="carousel-item anhsp-detail">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/views/img/${p.anh}" alt="Second slide">
                  </div>
                  <div class="carousel-item anhsp-detail">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/views/img/${p.anh}" alt="Third slide">
                  </div>
                </div>
                <a class="carousel-control-prev" role="button" data-slide="prev">
                 
                  <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" role="button" data-slide="next">
                 
                  <span class="sr-only">Next</span>
                </a>
              </div>
        </div>
        <div class="col-md-6">
        
        	<f:form action="${pageContext.request.contextPath }/detail/${p.id }" method="post" modelAttribute="data" enctype="multipart/form-data">
        	<f:input type="hidden" name="username" value="${account.username }" path="username"/>
        	<f:input type="hidden" name="idProduct" value="${p.id }" path="idProduct"/>
        	<f:input type="hidden" name="dongia" value="${p.giaDaGiam }" path="dongia"/>
            <div class="tieude">${fn:toUpperCase(p.tieuDe) }</div>
          
            <div class="detail-indam"><span><s:message code="homepage.detail.tinhtrang"/> :
              <c:if test="${count > 0}"><span style="color: green"><s:message code="homepage.detail.tinhtrang2"/></span></c:if>
              <c:if test="${count < 1}"><span style="color: red"><s:message code="homepage.detail.tinhtrang1"/></span></c:if>
            </span> 
             
              
            </div>
            <div class="inline detail-giamgia"><div class="gia inline"><fmt:formatNumber>${p.giaDaGiam}</fmt:formatNumber> VNĐ
              <div class="gia inline" ></div><p class="gach"><c:if test="${p.giamGia > 0 }">- <fmt:formatNumber>${p.giamGia}</fmt:formatNumber> % </c:if></p></div></div>
             <div class="detail-indam"><span><s:message code="homepage.detail.soluong"/> :</span> 
             <c:forEach items="${listKT }" var="kt">
             <span>[ ${kt.kichThuoc.tenKichThuoc} : ${kt.soLuong } ]</span>
                </c:forEach>
            </div>
            <div class="detail-indam"><span><s:message code="homepage.detail.kichthuoc"/> :</span>
                <br>
                <c:forEach items="${listKT }" var="kt">
               <c:if test="${kt.soLuong > 0 }">
               <f:radiobutton name="kichThuoc" value="${kt.kichThuoc.idKichThuoc }" path="kichthuoc"/>${kt.kichThuoc.tenKichThuoc }</>
               </c:if>
                </c:forEach>
                 
    
            
           
            </div>
           
            <div class="detail-indam"><span><s:message code="homepage.detail.mota"/> :</span> ${p.moTa }</div>
            <div class="detail-indam"><span><s:message code="homepage.detail.chatlieu"/> :</span> ${p.chatLieu }</div>
            <div class="detail-indam"><span><s:message code="homepage.detail.thietke"/> :</span> ${p.thietKe }</div>
            <br>
            <div class="themvaogio">
                <button class="nutthemgio-detail" type="submit"><a href="#"><i class="fa-solid fa-cart-shopping"></i><p class="gian"><s:message code="homepage.detail.nut"/></p></a></button>
            </div>
            <br>
            <div class="doitra">
                <div class="doitra-tieude"><s:message code="homepage.detail.doitra"/></div>
                <span><i class="fa-solid fa-check"></i> <s:message code="homepage.detail.doitra1"/></span><br>
                <span><i class="fa-solid fa-check"></i> <s:message code="homepage.detail.doitra2"/></span><br>
                <span><i class="fa-solid fa-check"></i> <s:message code="homepage.detail.doitra3"/></span>
            </div>
        	</f:form>
        </div>
    </div>
   </div>
   <br>
   <br>