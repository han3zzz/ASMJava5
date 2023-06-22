<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <h1 class="giua"><i class="fa-solid fa-bag-shopping"></i> <s:message code="homepage.product.title"/></h1>
      <br>
      
      <div class="row">
        <div class="col-md-1">
            <div class="col-md-6 category" data-mdb-filter="color">
               <h3 class="fa-lg"> <s:message code="homepage.product.danhmuc"/></h3>
                <div class="form-check mt-3">
               
                 <input
                    class="form-check-input"
                    type="radio"
                    name="inlineRadioOptions"
                    id="inlineRadio1"
                    value="Tất cả"
                    checked
                    onchange="window.location.replace('${pageContext.request.contextPath }/product')"
                  />
                  <label class="category-text" for="inlineRadio1"><s:message code="homepage.product.tatca"/></label>
               
                 
                   <c:forEach items="${listCate }" var="c">
                <c:if test="${c.trangThai == 0 }">
                 <input
                    class="form-check-input"
                    type="radio"
                    name="inlineRadioOptions"
                    id="inlineRadio1"
                    value="${c.id }"
                    ${id == c.id ? 'checked="checked"' : '' }
                    onchange="window.location.replace('${pageContext.request.contextPath }/product/${c.id }')"
                    ${c.id == cate ? 'checked="checked"' : '' }
                  />
                  <label class="category-text" for="inlineRadio1">${c.ten }</label>
            
                
                </c:if>
                
                </c:forEach>
                </div>
               
               </div>
              
            
          </div>
          <div class="col-md-11">
            <div class="container">
                <div class="row">
                  <c:forEach items="${list }" var="p">
          <div class="col-md-3 col-6">
            <div class="thumbnail xoagach">
              <a href="${pageContext.request.contextPath }/detail/${p.id }">
                <div class="anhsp"><c:if test="${p.giamGia > 0 }"><span class="giamgia1" >- ${p.giamGia}%</span></c:if><img src="${pageContext.request.contextPath}/views/img/${p.anh}" alt="Lights" style="width:100%"></div>
                <div class="tensp">
                  ${fn:toUpperCase(p.tieuDe)}
                </div>
              </a>
             <div class="line"><p class="money"> <c:if test="${p.giamGia < 1 }"><fmt:formatNumber>${p.gia}</fmt:formatNumber> VNĐ</c:if></p><p class="money"> <c:if test="${p.giamGia > 0 }"><fmt:formatNumber>${p.gia - (p.gia * (p.giamGia /100))}</fmt:formatNumber> VNĐ</c:if></p>
             <p class="gach"><c:if test="${p.giamGia >0 }"><fmt:formatNumber>${p.gia}</fmt:formatNumber> VNĐ</c:if></p>
              
            </div>
              <br>
              <div>
                <button class="nutthemgio"><a href="${pageContext.request.contextPath }/detail/${p.id }"><i class="fa-solid fa-cart-shopping"></i><p class="gian"><s:message code="homepage.product.nut"/></p></a></button>
              </div>
            </div>
<!--             <div class="ribbon-wrap"> -->
<!--               <div class="ribbon"><img class="fire" src="./img/fire.gif"> HOT</div> -->
<!--             </div> -->
        </div>
          </c:forEach>
           </div>
              <c:if test="${cate == null }">
               <nav aria-label="Page navigation example">
         
                  <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="product">1</a></li>
                  <c:forEach begin="2" end="${count }"  var="i">
                  <li class="page-item"><a class="page-link" href="?pageNum=${i}">${i }</a></li>
                  </c:forEach>
   
  </ul>
</nav>
              </c:if>
            <c:if test="${cate != null }">
             <nav aria-label="Page navigation example">
         
                  <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="?category=${cate }">1</a></li>
                  <c:forEach begin="2" end="${count }"  var="i">
                  <li class="page-item"><a class="page-link" href="?category=${cate }&page=${i}">${i }</a></li>
                  </c:forEach>
   
  </ul>
</nav>
            </c:if>
              </div>
              
          </div>
      </div>