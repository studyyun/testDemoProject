package com.example.test;

import gui.ava.html.image.generator.HtmlImageGenerator;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Canvas2 {
    public static void main(String[] args) {

        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        String htmlstr =" <div style=\"width:1000px;height:500px;border:1px black dashed;\">\n" +
                "    <h2 style=\"text-align: center\">检查结果报告单</h2>\n" +
                "    <div style=\"width: 950px;height: 0px;border-top: 1px solid black;margin: 0 auto;\"></div>\n" +
                "    <ul style=\"list-style-type: none\">\n" +
                "        <li style=\"float:left;\">\n" +
                "            <table>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">姓名:</th>\n" +
                "                    <td>李四</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">科室:</th>\n" +
                "                    <td>急诊儿科</td>\n" +
                "\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">临床诊断:</th>\n" +
                "                    <td>急性咽炎</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">检验目的:</th>\n" +
                "                    <td>病毒</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </li>\n" +
                "        <li style=\"margin-left: 100px;float:left;\">\n" +
                "            <table>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">性别:</th>\n" +
                "                    <td>男</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">床号:</th>\n" +
                "                    <td></td>\n" +
                "\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">样本类型:</th>\n" +
                "                    <td>血清蛋白</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </li>\n" +
                "        <li style=\"margin-left: 100px;float:left;\">\n" +
                "            <table>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">年龄:</th>\n" +
                "                    <td>45</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">临床医生:</th>\n" +
                "                    <td>小马</td>\n" +
                "\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">标本状态:</th>\n" +
                "                    <td>合格</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </li>\n" +
                "        <li style=\"margin-left: 100px;float:left;\">\n" +
                "            <table>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">样本号:</th>\n" +
                "                    <td>08426455</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th align=\"left\">住院/门诊号:</th>\n" +
                "                    <td>1024659</td>\n" +
                "\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </li>\n" +
                "    </ul>\n" +
                "    <div style=\"width: 950px;height: 0px;border-top: 1px solid black;margin: 0 auto;margin-top: 126px;\"></div>\n" +
                "     <div style=\"margin-left: 100px;margin-top: 5px;\">\n" +
                "         <span style=\"margin-right: 100px;\">项 目 名 称</span>\n" +
                "         <span style=\"margin-right: 70px;\">结果</span>\n" +
                "         <span style=\"margin-right: 50px;\">提示</span>\n" +
                "         <span style=\"margin-right: 70px;\">单位</span>\n" +
                "         <span style=\"margin-right: 50px;\">使用方法</span>\n" +
                "         <span>参考值</span>\n" +
                "     </div>\n" +
                "    <div style=\"width: 950px;height: 0px;border-top: 1px solid black;margin: 0 auto;margin-top: 4px;\"></div>\n" +
                "    <ol>\n" +
                "        <li>颜色</li>\n" +
                "        <li>形状</li>\n" +
                "        <li>脂肪球</li>\n" +
                "        <li>真菌</li>\n" +
                "        <li>颜色</li>\n" +
                "        <li>形状</li>\n" +
                "        <li>脂肪球</li>\n" +
                "        <li>真菌</li>\n" +
                "    </ol>\n" +
                "    <ul style=\"list-style-type: none;margin-left: 240px;margin-top: -186px;\">\n" +
                "        <li>阴性</li>\n" +
                "        <li>阴性</li>\n" +
                "        <li>阴性</li>\n" +
                "        <li>阴性</li>\n" +
                "        <li>阴性</li>\n" +
                "        <li>阴性</li>\n" +
                "        <li>阴性</li>\n" +
                "        <li>阴性</li>\n" +
                "    </ul>\n" +
                "    <ul style=\"list-style-type: none;margin-left: 350px;margin-top: -186px;\">\n" +
                "        <li> </li>\n" +
                "        <li> </li>\n" +
                "        <li> </li>\n" +
                "        <li>*</li>\n" +
                "        <li></li>\n" +
                "        <li>*</li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "    </ul>\n" +
                "    <ul style=\"list-style-type: none;margin-left: 440px;\">\n" +
                "        <li> </li>\n" +
                "        <li> </li>\n" +
                "        <li> </li>\n" +
                "        <li>/HPF</li>\n" +
                "        <li></li>\n" +
                "        <li>/HPF</li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "    </ul>\n" +
                "    <ul style=\"list-style-type: none;margin-left: 550px;margin-top: -120px;\">\n" +
                "        <li> </li>\n" +
                "        <li> SS</li>\n" +
                "        <li> </li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "    </ul>\n" +
                "\n" +
                "    <ul style=\"list-style-type: none;margin-left: 650px;\">\n" +
                "        <li> tr</li>\n" +
                "        <li> SSd</li>\n" +
                "        <li> adf</li>\n" +
                "        <li></li>\n" +
                "        <li>vsd</li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "        <li></li>\n" +
                "    </ul>\n" +
                "</div>\n";

        imageGenerator.loadHtml(htmlstr);
        imageGenerator.getBufferedImage();
        imageGenerator.saveAsImage("d:/hello.png");
        imageGenerator.saveAsHtmlWithMap("hello.html", "hello.png");
        log.info("图片生成----------------------------------------------------------");
    }


}
