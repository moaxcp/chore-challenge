<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'chore.label', default: 'Chore')}" />
        <title><g:message code="default.home.label" /></title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><a class="login" href="${createLink(uri: '/login')}"><g:message code="default.login.label"/></a></li>
                <form name="logout" method="POST" action="${createLink(controller:'logout')}">
                    <input type="submit" value="logout"/>
                </form>
            </ul>
        </div>
    </body>
</html>