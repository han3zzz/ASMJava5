<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <section class="vh-100" style="background-color: rgb(255, 255, 255);">
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
                        
                       
                          <f:form action="login" method="post" modelAttribute="data" enctype="multipart/form-data">
          
                            <div class="d-flex align-items-center mb-3 pb-1">
                              <span class="h1 fw-bold mb-0"> <h1 class="giua"><i class="fa-solid fa-right-to-bracket"></i> <s:message code="homepage.login.title"/> </h1></span>
                            </div>
          
                            <h6 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;"> <s:message code="homepage.login.mota"/></h6>
          
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form2Example17"><i class="fa-solid fa-user"></i>  <s:message code="homepage.login.taikhoan"/></label>
                              <f:input type="text" id="form2Example17" class="form-control form-control-lg" name="username" path="username"/>
                              <f:errors style="color:red" path="username" element="div"></f:errors>
                            </div>
          
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form2Example27"><i class="fa-solid fa-lock"></i>  <s:message code="homepage.login.matkhau"/></label>
                              <f:input type="password" id="form2Example27" class="form-control form-control-lg" name="password" path="password"/>
                               <f:errors style="color:red" path="password" element="div"></f:errors>
                              
                            </div>
                            <%--  <div class="form-outline mb-4">
                              <input type="checkbox">  <s:message code="homepage.login.checkbox"/>
                              
                            </div> --%>
          					
                            <div class="pt-1 mb-4">
                              <button class="btn btn-dark btn-lg btn-block" type="submit"><i class="fa-solid fa-arrow-right-to-bracket"></i> <s:message code="homepage.login.nut"/></button>
                            </div>
          
                            <a class="small text-muted" href="forget"> <s:message code="homepage.login.quenmatkhau"/></a>
                            <p class="mb-5 pb-lg-2" style="color: #393f81;"> <s:message code="homepage.login.dk"/> <a href="register"
                                style="color: #393f81;"> <s:message code="homepage.login.dangky"/></a></p>
                          </f:form>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>