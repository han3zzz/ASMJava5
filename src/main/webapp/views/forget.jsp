<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <c:if test="${account  == null }">
        <section class="vh-100" style="background-color: #fff;">
            <div class="container py-5 h-100">
              <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-xl-10">
                  <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                      <div class="col-md-6 col-lg-5 d-none d-md-block login">
                         <img src="./views/img/login.gif"
                          alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                      </div>
                      <div class="col-md-6 col-lg-7 d-flex align-items-center">
                        <div class="card-body p-4 p-lg-5 text-black">
          			
                          <f:form action="forget" method="post" modelAttribute="data">
          
                            <div class="d-flex align-items-center mb-3 pb-1">
                              <span class="h1 fw-bold mb-0"> <h1 class="giua"><i class="fa-solid fa-paper-plane"></i> <s:message code="homepage.forget.title"/> </h1></span>
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form2Example17"><i class="fa-solid fa-user"></i> <s:message code="homepage.forget.taikhoan"/></label>
                              <f:input type="text" id="form2Example17" class="form-control form-control-lg" name="username" path="username"/>
                              <f:errors style="color:red" path="username" element="div"></f:errors>
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form2Example17"><i class="fa-solid fa-envelope"></i> Email</label>
                              <f:input type="email" id="form2Example17" class="form-control form-control-lg" name="email" path="email"/>
                                <f:errors style="color:red" path="email" element="div"></f:errors>
                            </div>
                            <div class="pt-1 mb-4">
                              <button class="btn btn-dark btn-lg btn-block" type="submit"><i class="fa-solid fa-square-plus"></i> <s:message code="homepage.forget.nut"/></button>
                            </div>
                            
                          </f:form>
          
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </c:if>
          
        <c:if test="${account != null }">
      <h1>Vui lòng đăng xuất trước khi thực hiện chức năng này !</h1>
      </c:if>
