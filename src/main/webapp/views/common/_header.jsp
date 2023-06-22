<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<header >
    <nav class="navbar navbar-expand-lg navbar-light nav">
      <a class="navbar-brand" href="index"><img class="logo" src="${pageContext.request.contextPath}/views/img/logo.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent" >
          <ul class="navbar-nav mr-auto">
            <li class="nav-item menu">
              <a class="chu-m" href="${pageContext.request.contextPath}/index"><i class="fa-solid fa-house"></i> <s:message code="homepage.menu.home"/> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item menu">
              <a class="chu-m" href="${pageContext.request.contextPath}/product"><i class="fa-solid fa-bag-shopping"></i> <s:message code="homepage.menu.product"/></a>
            </li>
            <li class="nav-item menu">
              <a class="chu-m" href="${pageContext.request.contextPath}/info"><i class="fa-solid fa-circle-info"></i> <s:message code="homepage.menu.about"/></a>
            </li> 
    		<c:if test="${account.role ==0 }"><li class="nav-item menu">
              <a class="chu-m" href="${pageContext.request.contextPath}/manage"><i class="fa-solid fa-rocket"></i> <s:message code="homepage.menu.manage"/></a>
            </li>
             </c:if>
            
            
          </ul>
          <div class="button-cangiua">
         <div style="margin-left: 70px; margin-bottom: 3px" >
					<a style="color: black; text-decoration: none; padding-right: 10px"
						href="?language=vi"><img style="width: 30px ; height: 30px" src="${pageContext.request.contextPath}/views/img/vn.png"></a>|<a
						style="color: black; text-decoration: none; padding-left: 10px"
						href="?language=en"><img style="width: 30px ; height: 30px" src="${pageContext.request.contextPath}/views/img/uk.png"></a>
				</div>
          <button class="nut"><a class="nav-link menu" href="${pageContext.request.contextPath}/cart"><i class="fa-solid fa-cart-shopping"></i></a>
          
          </button>
          
          <button class="nuthan dropdown show">
            <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <i class="fa-solid fa-user"></i> <s:message code="homepage.menu.hi"/> , <c:if test="${account != null }">${account.username}</c:if>
    <c:if test="${account == null }"><s:message code="homepage.menu.khach"/></c:if>
  </a>
  <c:choose>
  <c:when test="${account != null }">
  <div class="dropdown-menu drop" aria-labelledby="dropdownMenuLink">
    <div class="nutdrop">
    <a class="dropdown-item" href="${pageContext.request.contextPath}/my-order"><s:message code="homepage.menu.donhang"/></a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/change"><s:message code="homepage.menu.change"/></a>
    <a class="dropdown-item" href="#" onclick="dangXuat()"><s:message code="homepage.menu.logout"/></a>
    </div>
  </div>
  </c:when>
  <c:otherwise>
  <div class="dropdown-menu drop" aria-labelledby="dropdownMenuLink">
    <div class="nutdrop">
    <a class="dropdown-item" href="${pageContext.request.contextPath}/login"><s:message code="homepage.menu.login"/></a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/register"><s:message code="homepage.menu.register"/></a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/forget"><s:message code="homepage.menu.forget"/></a>
    </div>
  </div>
  </c:otherwise>
  </c:choose>
  
          </button>

          </div>
        </div>
      </nav>
  </header>
    <br>
    <script>
    	function dangXuat() {
    		Swal.fire({
    			  title: '<s:message code="homepage.menu.titleDangXuat"/>',
    			  showCancelButton: true,
    			  confirmButtonText: '<s:message code="homepage.menu.chonDangXuat"/>',
    			}).then((result) => {
    			  /* Read more about isConfirmed, isDenied below */
    			  if (result.isConfirmed) {
    				  Swal.fire('<s:message code="homepage.menu.thongbaoDangXuat"/>', '', 'success');
    				  setTimeout(() => {
    					  location.href = "${pageContext.request.contextPath}/logout";
					}, 2000);
    				
    			    
    			  } else if (result.isDenied) {
    			   
    			  }
    			})
		}
    	
    </script>