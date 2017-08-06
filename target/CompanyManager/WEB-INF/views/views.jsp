<!DOCTYPE tiles-definitions PUBLIC
"-//Apache Software Foundation//DTD Tiles Configuration 2.1//EN"
"http://tiles.apache.org/dtds/tiles-config_2_1.dtd">
<tiles-definitions>
    <definition name="template"
                template="/WEB-INF/views/main_template.jsp"> <!-- Общий шаблон -->
        <put-attribute name="top"
                       value="/WEB-INF/views/tiles/spittleForm.jsp" />
        <put-attribute name="side"
                       value="/WEB-INF/views/tiles/signinsignup.jsp" />
    </definition>
    <definition name="home" extends="template"> <!-- Шаблон главной страницы -->
        <put-attribute name="content" value="/WEB-INF/views/home.jsp" />
    </definition>
</tiles-definitions>
