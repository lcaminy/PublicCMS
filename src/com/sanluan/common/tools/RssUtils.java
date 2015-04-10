package com.sanluan.common.tools;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RssUtils {

	@SuppressWarnings("unchecked")
	public static List<SyndEntry> parseRss(String rssUrl) {
		try {
			XmlReader reader = new XmlReader(new URL(rssUrl));
			SyndFeed feed = new SyndFeedInput().build(reader);
			return feed.getEntries();
		} catch (Exception e) {
			return new ArrayList<SyndEntry>();
		}
	}
}
