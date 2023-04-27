import static org.junit.Assert.*;
import org.junit.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class TestDocSearch {
	@Test 
	public void testIndex() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/");
    assertEquals("There are 224 total files to search.", h.handleRequest(rootPath));
	}
	@Test 
	public void testSearch() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/search?q=sushi");
    String expect = "Found 3 paths:\n./written_2/travel_guides/berlitz1/WhatToJapan.txt\n./written_2/travel_guides/berlitz1/WhereToJapan.txt\n./written_2/travel_guides/berlitz2/California-WhereToGo.txt";
    assertEquals(expect, h.handleRequest(rootPath));
	}
    
    @Test 
	public void testSearchPlos() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/plos/");
    URI rootPath = new URI("http://localhost/search?q=base%20pair");
    String expect = "Found 2 paths:\ntechnical\\plos\\journal.pbio.0020190.txt\ntechnical\\plos\\journal.pbio.0020223.txt\n";
    assertEquals(expect, h.handleRequest(rootPath));
	}
}

