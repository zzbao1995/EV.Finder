package edu.findvideo.util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.findvideo.bean.Gramma;
import net.java.sen.StringTagger;
import net.java.sen.Token;
public class SenUtil {

    private static String confPath = "";
    private static SenUtil senUtil = null;

    static {
        File path = new File(Thread.currentThread().getContextClassLoader().getResource("").toString());
        String abPath = path.getParentFile().getPath();
        abPath = abPath.substring(5, abPath.length());
        confPath = abPath + "/senDic/conf/sen.xml";
        confPath = confPath.replaceAll("%20", " "); //你妹啊。。有些空格被转成了 %20
    }

    private SenUtil() {
    }

    public static SenUtil getInstance() {
        if (null == senUtil) {
            senUtil = new SenUtil();
        }
        return senUtil;
    }

    /*
     * 通过对句子进行分词后， 返回一个个的GrammaUtil
     * 注意这些GrammUtil还没有Id哦
     */
    public synchronized ArrayList<GrammaUtil> getGrammasBySentence(String sentence, int sentenceId) {
        if (sentence.equals("")) {
            return null;
        }

        sentence = sentence.replaceAll("\\s", "");
        sentence = sentence.replaceAll("　", "");   //注意哦，这个不是空格哦亲~。。

        try {
            StringTagger tagger = StringTagger.getInstance(confPath);
            Token[] token = tagger.analyze(sentence);
            //添加对品词的简化操作
            String preficProperty = "";

            ArrayList<GrammaUtil> tmp = new ArrayList<GrammaUtil>();

            for (int i = 0 ; i < token.length  ; i ++ ) {

//                 /**********************debug**************************/
//                 System.out.println("AddInfo=" + token[i].getAddInfo());
//                 System.out.println("BasicString=" + token[i].getBasicString());
//                 System.out.println("Cform=" + token[i].getCform());
//                 System.out.println("Pos=" + token[i].getPos());
//                 System.out.println("Pronunciation=" + token[i].getPronunciation());
//                 System.out.println("Reading=" + token[i].getReading());
//                 System.out.println("Surface=" + token[i].getSurface());
//                 System.out.println("TermInfo=" + token[i].getTermInfo());
//                 System.out.println("length=" + token[i].length());
//                 System.out.println("start=" + token[i].start());
//                 System.out.println("end=" + token[i].end());
//                 System.out.println("Cost=" + token[i].getCost());
//
//                 /**********************debug**************************/
                if (token[i].getPos().charAt(2) == '詞')
                    preficProperty = token[i].getPos().substring(0, 3);
                else
                    preficProperty = token[i].getPos().substring(0, 2);

                GrammaUtil t_gramma = new GrammaUtil(-1, token[i].getSurface(), preficProperty,
                        token[i].getPronunciation(), sentenceId, 1, token[i].getBasicString(),
                        token[i].start());
                tmp.add(t_gramma);
            }

            return tmp;
        } catch (IOException ex) {
            Logger.getLogger(SenUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SenUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //这里返回的Gramma的sentenceId和WrongId没有赋值
    //返回的ArrayList<Gramma>中固定有6个对象， 如果关键词中没有前三后三， 则返回对象的
    //surface为""
    public synchronized ArrayList<GrammaUtil>  relateWordsProperty(String sentenceWithSpace, String keyWordSurface){
        try {
            //先把空格都去掉
            String sentence = sentenceWithSpace.replaceAll(" ", "");
            StringTagger tagger = StringTagger.getInstance(confPath);
            Token[] token = tagger.analyze(sentence);
            ArrayList<GrammaUtil> tmp = new ArrayList<GrammaUtil>();

            for (int i = 0; i < token.length; i++) {
                GrammaUtil gramma = new GrammaUtil();
                gramma.setSurface(token[i].getSurface());
                gramma.setProperty(token[i].getPos());
                gramma.setPronunciation(token[i].getPronunciation());
                gramma.setBasic(token[i].getBasicString());
                gramma.setPos(token[i].start());
                tmp.add(gramma);
            }

            int keyWordSurfaceIndex = -1;
            //先找到keyWordSurface的位置
            for (int i = 0; i < tmp.size(); i++) {
                if (tmp.get(i).getSurface().equals(keyWordSurface)) {
                    keyWordSurfaceIndex = i;
                }
            }

            //没找到
            if (keyWordSurfaceIndex == -1) {
                return null;
            }

            ArrayList<GrammaUtil> returnWords = new ArrayList<GrammaUtil>();
            //依次查看keyWordSurfaceIndex的前三个和后三个
            for (int i = keyWordSurfaceIndex - 3; i <= keyWordSurfaceIndex + 3; i++) {
                if (i != keyWordSurfaceIndex) {
                    if (i >= 0 && i <tmp.size() ) {
                        returnWords.add(tmp.get(i));
                    } else {
                        GrammaUtil gramma = new GrammaUtil();
                        gramma.setSurface("");
                        gramma.setProperty("");

                        returnWords.add(gramma);
                    }
                }
            }

            return returnWords;
        } catch (IOException ex) {
            Logger.getLogger(SenUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SenUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /*
     * 对一个短语（也可能是只有一个词）进行分词
     * 返回得到的gramma列表
     */
    public synchronized ArrayList<Gramma>  getGrammasByPhrase(String phrase) {
        ArrayList<Gramma> grammas = new ArrayList<Gramma>();
        try {
            //先把空格都去掉
            if(phrase.equals(""))
                return grammas;
            phrase = phrase.replaceAll(" ", "");
            StringTagger tagger = StringTagger.getInstance(confPath);
            Token[] token = tagger.analyze(phrase);

            for (int i = 0; i < token.length; i++) {
                Gramma gramma = new Gramma();
                gramma.setSurface(token[i].getSurface());
                gramma.setProperty(token[i].getPos());
                gramma.setPronunciation(token[i].getPronunciation());
                gramma.setBasic(token[i].getBasicString());
                grammas.add(gramma);
            }
        } catch (IOException ex) {
            Logger.getLogger(SenUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grammas;
    }
}
