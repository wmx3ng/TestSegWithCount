package cn.com.test.wong.token.analysis;

import org.apdplat.word.recognition.Punctuation;
import org.apdplat.word.recognition.RecognitionTool;
import org.apdplat.word.recognition.StopWord;
import org.apdplat.word.segmentation.Word;
import org.apdplat.word.segmentation.impl.AbstractSegmentation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 5:14 PM 2/15/17.
 * Version:
 * Description:
 */
public class StatHotWords extends AbstractSegmentation {

    public List<String> getHotWords(String text, int queueSize) {
        List<String> newWords = new ArrayList<String>();
        List<Word> result = segImpl(text, queueSize);
        int posStart = 0;
        int posEnd = posStart;

        while (posEnd < result.size()) {
            while (posEnd < result.size() && posEnd - posStart < queueSize) {
                String word = result.get(posEnd).toString();
                if (StopWord.is(word)) {
                    posStart = posEnd + 1;
                    posEnd = posStart;
                } else {
                    posEnd++;
                }
            }
            if (posEnd - posStart == queueSize) {
                List<Word> subList = result.subList(posStart, posEnd);
                String newWord = "";
                for (Word word : subList) {
                    newWord += word.toString();
                }
                newWords.add(newWord);
            }

            posStart++;
        }

        return newWords;
    }
    @Override
    public List<Word> segImpl(String text) {
        return segImpl(text, 1);
    }

    public List<Word> segImpl(String text, int wordLength) {
        List<Word> result = new ArrayList<Word>();
        List<String> sentences = Punctuation.seg(text, KEEP_PUNCTUATION);
        for (String sentence : sentences) {
            result.addAll(getWordsFromSingleSentence(sentence, wordLength));
        }

        return result;
    }

    private List<Word> getWordsFromSingleSentence(String text, final int queueSize) {

        List<Word> result = new ArrayList<Word>();
        //文本长度
        final int textLen = text.length();
        //从未分词的文本中截取的长度
        int len = getInterceptLength();
        //剩下未分词的文本的索引
        int start = 0;
        //只要有词未切分完就一直继续
        while (start < textLen) {
            if (len > textLen - start) {
                //如果未分词的文本的长度小于截取的长度
                //则缩短截取的长度
                len = textLen - start;
            }
            //用长为len的字符串查词典，并做特殊情况识别
            while (!DIC.contains(text, start, len) && !RecognitionTool.recog(text, start, len)) {
                //如果长度为一且在词典中未找到匹配
                //则按长度为一切分
                if (len == 1) {
                    break;
                }
                //如果查不到，则长度减一后继续
                len--;
            }
            addWord(result, text, start, len);
            //从待分词文本中向后移动索引，滑过已经分词的文本
            start += len;
            //每一次成功切词后都要重置截取长度
            len = getInterceptLength();
        }


        return result;
    }

}
