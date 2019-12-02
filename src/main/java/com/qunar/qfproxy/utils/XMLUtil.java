package com.qunar.qfproxy.utils;

import com.qunar.qfproxy.constants.PackageXMLConstant;
import com.qunar.qfproxy.model.EmoPackXML;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class XMLUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmoPackageUtil.class);

    public static Document dom4jToXml(EmoPackXML emoPackXML) {
        EmoPackXML.FACESETTINGBean.DEFAULTFACEBean facesettingBean = emoPackXML.getFACESETTING().getDEFAULTFACE();
        Document document = DocumentHelper.createDocument();
        org.dom4j.Element ROOT = document.addElement(PackageXMLConstant.FACESETTING);
        org.dom4j.Element bookStore = ROOT.addElement(PackageXMLConstant.DEFAULTFACE);
        bookStore.addAttribute(PackageXMLConstant.EMOTIONNAME, facesettingBean.getEmotionName());
        bookStore.addAttribute(PackageXMLConstant.VERSION, facesettingBean.getVersion());
        bookStore.addAttribute(PackageXMLConstant.COUNT, facesettingBean.getCount());
        bookStore.addAttribute(PackageXMLConstant.SHOWALL, facesettingBean.getShowall());
        bookStore.addAttribute(PackageXMLConstant.LINE, facesettingBean.getLine());
        bookStore.addAttribute(PackageXMLConstant.Width, facesettingBean.getWidth());
        bookStore.addAttribute(PackageXMLConstant.Height, facesettingBean.getHeight());
        bookStore.addAttribute("package", facesettingBean.getPackageX());
        List<EmoPackXML.FACESETTINGBean.DEFAULTFACEBean.FACEBean> beans = facesettingBean.getFACE();

        if (beans == null || beans.size() < 0) {
            return null;
        }
        for (EmoPackXML.FACESETTINGBean.DEFAULTFACEBean.FACEBean bean : beans) {
            org.dom4j.Element face = bookStore.addElement(PackageXMLConstant.FACE);
            face.addAttribute(PackageXMLConstant.id, bean.getId());
            face.addAttribute(PackageXMLConstant.shortcut, bean.getShortcut());
            face.addAttribute(PackageXMLConstant.tip, bean.getTip());
            face.addAttribute(PackageXMLConstant.multiframe, bean.getMultiframe());
            org.dom4j.Element faceOrg = face.addElement(PackageXMLConstant.FILE_ORG);
            faceOrg.setText(bean.getFILE_ORG());
            org.dom4j.Element fileFix = face.addElement(PackageXMLConstant.FILE_FIXED);
            fileFix.setText(bean.getFILE_FIXED());
        }
        //return true;
//        OutputFormat format = OutputFormat.createPrettyPrint();
//        try {
//            XMLWriter writer = new XMLWriter(new FileOutputStream(new File("/Users/binzhang/Downloads/package/tets.xml")), format);
//            writer.write(document);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return document;
    }

    public static void main(String[] args) {
        int valueTen = 128320;
        //将其转换为十六进制并输出
        String strHex = Integer.toHexString(valueTen);
        LOGGER.info(valueTen + " [十进制]---->[十六进制] " + strHex);
        //将十六进制格式化输出
        String strHex2 = String.format("%07x",valueTen);
        LOGGER.info(valueTen + " [十进制]---->[十六进制] " + strHex2);

        LOGGER.info("==========================================================");
        //定义一个十六进制值
        String strHex3 = "00001322";
        //将十六进制转化成十进制
        int valueTen2 = Integer.parseInt(strHex3,16);
        LOGGER.info(strHex3 + " [十六进制]---->[十进制] " + valueTen2);

        LOGGER.info("==========================================================");
        //可以在声明十进制时，自动完成十六进制到十进制的转换
        int valueHex = 0x00001322;
        LOGGER.info("int valueHex = 0x00001322 --> " + valueHex);

    }
}
