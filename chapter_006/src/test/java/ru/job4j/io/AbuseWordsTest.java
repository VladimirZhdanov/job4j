package ru.job4j.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AbuseWordsTest {

    @Test
    public void when() {
        ByteArrayInputStream in = new ByteArrayInputStream("OMG that was unbelievable LOL".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String[] abuseWords = new String[]{"LOL", "OMG"};
        AbuseWords aw = new AbuseWords();
        aw.dropAbuses(in, out, abuseWords);
        String expected = "that was unbelievable";
        String result = aw.toString();
        assertThat(out.toString(), is(expected));
    }

}