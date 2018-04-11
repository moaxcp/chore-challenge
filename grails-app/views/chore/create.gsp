<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <asset:stylesheet src="jquery-editable-select.css"/>
        <g:set var="entityName" value="${message(code: 'chore.label', default: 'Chore')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-chore" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-chore" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.chore}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.chore}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.chore}" method="POST">
                <fieldset class="form">
                    <f:with bean="chore">
                        <f:field property="summary"/>
                        <f:field property="description">
                            <g:textArea name="${property}" style="width:100%" rows="5" value="${it.value}"/>
                        </f:field>
                        <f:field property="points"/>
                        <f:field property="finishBy"/>
                        <f:field property="zone">
                            <g:select id="zone" name="chore.zone.name" from="${zones}" optionKey="name" optionValue="name"/>
                        </f:field>
                        <f:field property="schedule"/>
                        <f:field property="excludeUsers"/>
                        <f:field property="includeUsers"/>
                    </f:with>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
        <content tag="javascript">
            <script>
                $('#zone').editableSelect();
            </script>
        </content>
    </body>
</html>
