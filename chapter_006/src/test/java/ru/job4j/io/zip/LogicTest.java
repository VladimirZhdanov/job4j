package ru.job4j.io.zip;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * LogicTest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class LogicTest {

    @Test
    public void when() {
        Logic logic = new Logic();
        var parameters = new String[3];
        parameters[0] = "C:\\projects\\job4j";
        parameters[1] = ".txt";
        parameters[2] = "project.zip";
        Args args = new Args(parameters);
        logic.zipping(args);
        assertThat(new File((args.directory() + "\\" + args.output())).exists(), is(true));
    }
}
