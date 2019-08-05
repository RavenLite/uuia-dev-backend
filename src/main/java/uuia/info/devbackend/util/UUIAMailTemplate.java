package uuia.info.devbackend.util;

/**
 * @Author: Raven
 * @Date: 2019/8/5 7:39 PM
 */
public class UUIAMailTemplate {
    private static final String templateHTML = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
            "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"zh-cn\">\n" +
            "<head>\n" +
            "    <title>UUIA</title>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0 \"/>\n" +
            "    <meta name=\"format-detection\" content=\"telephone=no\"/>\n" +
            "    <style type=\"text/css\">\n" +
            "        body {\n" +
            "            -webkit-text-size-adjust: 100% !important;\n" +
            "            -ms-text-size-adjust: 100% !important;\n" +
            "            -webkit-font-smoothing: antialiased !important;\n" +
            "            font-family:'Open Sans', Arial, sans-serif;\n" +
            "        }\n" +
            "\n" +
            "        table {\n" +
            "            border-collapse: collapse;\n" +
            "            mso-table-lspace: 0;\n" +
            "            mso-table-rspace: 0;\n" +
            "        }\n" +
            "\n" +
            "        td,\n" +
            "        a,\n" +
            "        span {\n" +
            "            border-collapse: collapse;\n" +
            "            mso-line-height-rule: exactly;\n" +
            "        }\n" +
            "\n" +
            "        .card {\n" +
            "            margin: 30px;\n" +
            "            padding: 30px;\n" +
            "            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.20);\n" +
            "            border-radius: 15px;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body style=\"text-align: center\">\n" +
            "<table class=\"card\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fafafa\">\n" +
            "    <!-- === PRE HEADER SECTION=== -->\n" +
            "    <tr>\n" +
            "        <td align=\"center\" valign=\"top\" bgcolor=\"#f5f5f5\" style=\"border-top-left-radius: 15px; border-top-right-radius: 15px\">\n" +
            "            <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\"\n" +
            "                   style=\"table-layout:fixed;\">\n" +
            "                <tr>\n" +
            "                    <td align=\"left\">\n" +
            "                        <div style=\"height:50px;line-height:50px; font-size: 28px; padding: 15px;\">\n" +
            "                            <!-- === LOGO SECTION === -->\n" +
            "                            <a href=\"#\" target=\"_blank\">\n" +
            "                                <img style=\"border-radius: 15px; vertical-align:middle;\"\n" +
            "                                     src=\"https://avatars1.githubusercontent.com/u/49345912?s=200&v=4\" height=\"50px\"\n" +
            "                                     border=\"0\" alt=\"UUIA\"/></a>\n" +
            "                            <span> #!title#</span>\n" +
            "                        </div>\n" +
            "                    </td>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "            </table>\n" +
            "        </td>\n" +
            "    </tr>\n" +
            "    <!-- === //PRE HEADER SECTION=== -->\n" +
            "    <!-- === BODY SECTION=== -->\n" +
            "    <tr>\n" +
            "        <td align=\"center\" valign=\"center\">\n" +
            "            <div style=\"table-layout:fixed; margin: 20px\">\n" +
            "                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-weight:normal; color:#333333;\">\n" +
            "                    <tr>\n" +
            "                        <td align=\"left\">\n" +
            "                            <p><b>#!heading#</b></p>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td align=\"left\">\n" +
            "                            <p>#!content#</p>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td height=\"20\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td valign=\"top\" align=\"center\">\n" +
            "                            <table width=\"210\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
            "                                <tr>\n" +
            "                                    <td valign=\"middle\" align=\"center\" height=\"60\" bgcolor=\"#1976d2\"\n" +
            "                                        style=\"font-size:17px; font-weight:bold; border-radius: 15px\">\n" +
            "                                        <a href=\"#!button-link#\" style=\"color: #efefef\"> #!button-text# </a>\n" +
            "                                    </td>\n" +
            "                                </tr>\n" +
            "                            </table>\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td height=\"31\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td align=\"right\" style=\"color:#1976d2;\">\n" +
            "                            #!ending#\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td height=\"31\">&nbsp;</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                        <td align=\"center\"\n" +
            "                            style=\"font-family:'Open Sans', Arial, sans-serif; font-size:15px; line-height:20px; color:#999999;\">\n" +
            "                            此为 UUIA 的通知邮件，您可以前往 UUIA 站点查看更多资讯。\n" +
            "                        </td>\n" +
            "                    </tr>\n" +
            "                </table>\n" +
            "            </div>\n" +
            "        </td>\n" +
            "    </tr>\n" +
            "    <!-- === //BODY SECTION=== -->\n" +
            "    <!-- === FOOTER SECTION === -->\n" +
            "    <tr>\n" +
            "        <td align=\"center\" valign=\"top\" style=\"border-bottom-left-radius: 15px; border-bottom-right-radius: 15px\">\n" +
            "            <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\"\n" +
            "                   style=\"table-layout:fixed;\" color=\"#666666\">\n" +
            "                <tr>\n" +
            "                    <td height=\"35\">&nbsp;</td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                    <td align=\"center\"\n" +
            "                        style=\"font-size:12px; line-height:18px; color:#e8e8e8; text-transform:uppercase;\">\n" +
            "                        <span style=\"text-decoration:underline;\"><a href=\"https://github.com/uuia\" target=\"_blank\"\n" +
            "                                                                    style=\"text-decoration:underline; color:#666666;\">UUIA on Github</a></span>\n" +
            "                        &nbsp;&nbsp;|&nbsp;&nbsp; <span style=\"text-decoration:underline;\"><a\n" +
            "                            href=\"https://github.com/uuia/UUIA/blob/master/UUIA-LICENSE.md\" target=\"_blank\" style=\"text-decoration:underline; color:#666666;\">UUIA License</a></span>\n" +
            "                        <span> &nbsp;&nbsp;</span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                    <td align=\"center\"\n" +
            "                        style=\"font-size:12px; line-height:18px; text-transform:uppercase;\">\n" +
            "                        Presents by UUIA. All Rights Reserved. <br> 由 UUIA 提供。保留所有权利。\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                    <td height=\"10\" style=\"font-size:1px; line-height:1px;\">&nbsp;</td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                    <td height=\"35\">&nbsp;</td>\n" +
            "                </tr>\n" +
            "            </table>\n" +
            "        </td>\n" +
            "    </tr>\n" +
            "    <!-- === //FOOTER SECTION === -->\n" +
            "</table>\n" +
            "</body>\n" +
            "</html>";

    private String title;
    private String heading = "尊敬的阁下：";
    private String ending = "UUIA 运营管理组敬上";
    private String content = "";
    private String buttonText = "转到 UUIA";
    private String buttonLink = "#";

    public UUIAMailTemplate() {
    }

    public String compile() {
        String codeToReturn = templateHTML;
        codeToReturn = codeToReturn.replace("#!title#", title);
        codeToReturn = codeToReturn.replace("#!heading#", heading);
        codeToReturn = codeToReturn.replace("#!content#", content);
        codeToReturn = codeToReturn.replace("#!button-text#", buttonText);
        codeToReturn = codeToReturn.replace("#!button-link#", buttonLink);
        codeToReturn = codeToReturn.replace("#!ending#", ending);
        return codeToReturn;
    }

    @Override
    public String toString() {
        return compile();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String starting) {
        this.heading = starting;
    }

    public String getEnding() {
        return ending;
    }

    public void setEnding(String ending) {
        this.ending = ending;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public void setButtonLink(String buttonLink) {
        this.buttonLink = buttonLink;
    }
}
