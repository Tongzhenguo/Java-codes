/*
package crawler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestCurrent {
	public static void main(String[] args) throws IOException, WriteException {
		*/
/*
		 * 从表格中抓取前一百歌名
		 *//*

		List<String> songList = new ArrayList();
		try {
			File file = new File("E:\\doc\\业务\\DB\\xaa.csv");
			InputStream in = new FileInputStream(file);
			Workbook workbook = Workbook.getWorkbook(in);
			Sheet sheet = workbook.getSheet(0);
			for (int i = 1; i < 1000; i++) {
				String[] songInfo = new String[6];
				// videoId
				Cell cell = sheet.getCell(0, i);
				String videoId = cell.getContents();
				// songName
				cell = sheet.getCell(1, i);
				String songName = cell.getContents();
				// allArtistNameAndId
				cell = sheet.getCell(2, i);
				String allArtistNameAndId = cell.getContents();
				// levelOneCataId
				cell = sheet.getCell(3, i);
				String levelOneCataId = cell.getContents();
				// levelTwoCataId
				cell = sheet.getCell(4, i);
				String levelTwoCataId = cell.getContents();
				// levelThreeCataId
				cell = sheet.getCell(5, i);
				String levelThreeCataId = cell.getContents();
				String YYTsongAllInfo = videoId + "!@#" + songName + "!@#"
						+ allArtistNameAndId + "!@#" + levelOneCataId + "!@#"
						+ levelTwoCataId + "!@#" + levelThreeCataId;
				songList.add(YYTsongAllInfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		WritableWorkbook wb;

		wb = Workbook.createWorkbook(new File("E:\\doc\\业务\\DB\\jieguo.xlsx"));
		WritableSheet ws = wb.createSheet("jieguo", 0);
		int excelCounts = 0;
		for (int i = 0; i < songList.size(); i++) {
			try {
				String str = songList.get(i).split("!@#")[1];
				str = java.net.URLEncoder.encode(str, "UTF-8");

				*/
/*
				 * 抓取虾米匹配歌曲列表页面
				 *//*

				Document doc = Utils
						.getDocument("http://www.xiami.com/search?key=" + str
								+ "&pos=1");
				if (doc == null) {
					continue;
				}

				*/
/*
				 * 抓取虾米歌曲列表
				 *//*

				List<String> xiamiSongList = new ArrayList<String>();
				Elements tBodyList = (Elements) doc.select(
						"[class=result_main]").select("[class=track_list]")
						.select("tbody");
				Elements tEndBodyList = new Elements();
				for (Element element : tBodyList) {
					tEndBodyList.addAll(element
							.select("[class=same_song_group]"));
				}
				tBodyList.removeAll(tEndBodyList);

				// 循环title
				for (Element elements : tBodyList) {
					for (Element elementss : elements.select("tr")) {
						for (Element elementsss : elementss.select(
								"[class=song_name]").select("a")) {
							String artistName = elementss.select(
									"[class=song_artist]").select("a").attr(
									"title");
							String xiamiNameAndHrefAndArtistName = elementsss
									.attr("title")
									+ "#,#"
									+ elementsss.attr("href")
									+ "#,#"
									+ artistName;
							xiamiSongList.add(xiamiNameAndHrefAndArtistName);
						}

					}
				}

				*/
/*
				 * 寻找与音悦台相匹配的第一条虾米音乐名
				 *//*

				String[] sonListArr = songList.get(i).split("!@#");
				String YYTsongNameFilter = Utils.replaceSpecStr(sonListArr[1]);
				String YYTsongArtistFilter = Utils
						.replaceSpecStr(sonListArr[2]);
				FinalMatchStatusEnum matchStatus = FinalMatchStatusEnum.ZERO;
				String xiamiHref = "";
				String xiamiMatchName = "";
				String finalXiamiArtist = "";
				while (true) {
					// 查找完全匹配
					for (String xiamiNameAndHrefAndArtistName : xiamiSongList) {
						if (Utils.isBlank(xiamiNameAndHrefAndArtistName) == true) {
							continue;
						}
						String xiamiName = xiamiNameAndHrefAndArtistName
								.split("#,#")[0];
						String xiamiArtist = xiamiNameAndHrefAndArtistName
								.split("#,#")[2];
						// 歌名匹配
						String xiamiSongFilter = Utils
								.replaceSpecStr(xiamiName);
						if (YYTsongNameFilter.equalsIgnoreCase(xiamiSongFilter)) {
							// 歌名匹配的基础上，看艺人是否匹配
							if (YYTsongArtistFilter.toLowerCase().contains(
									xiamiArtist.toLowerCase())) {
								matchStatus = FinalMatchStatusEnum.TWO;
								// 获得完全匹配，取当前虾米歌曲链接
								xiamiHref = xiamiNameAndHrefAndArtistName
										.split("#,#")[1];
								xiamiMatchName = xiamiName;
								finalXiamiArtist = xiamiArtist;
								break;
							}
						}
					}
					if (matchStatus == FinalMatchStatusEnum.TWO) {
						break;
					}
					// 精准匹配MV名，未匹配歌手名
					for (String xiamiNameAndHrefAndArtistName : xiamiSongList) {
						if (Utils.isBlank(xiamiNameAndHrefAndArtistName) == true) {
							continue;
						}
						String xiamiName = xiamiNameAndHrefAndArtistName
								.split("#,#")[0];
						String xiamiArtist = xiamiNameAndHrefAndArtistName
								.split("#,#")[2];
						// 歌名匹配
						String xiamiSongFilter = Utils
								.replaceSpecStr(xiamiName);
						if (YYTsongNameFilter.equalsIgnoreCase(xiamiSongFilter)) {
							// 歌名匹配的基础上，看艺人是否匹配
							if (!(YYTsongArtistFilter.toLowerCase()
									.contains(xiamiArtist.toLowerCase()))) {
								matchStatus = FinalMatchStatusEnum.ONE;
								// 歌名匹配，取当前虾米歌曲链接
								xiamiHref = xiamiNameAndHrefAndArtistName
										.split("#,#")[1];
								xiamiMatchName = xiamiName;
								finalXiamiArtist = xiamiArtist;
								break;
							}
						}
					}
					if (matchStatus == FinalMatchStatusEnum.ONE) {
						break;
					}

					// 音悦台歌名包含虾米音乐歌名
					for (String xiamiNameAndHrefAndArtistName : xiamiSongList) {
						if (Utils.isBlank(xiamiNameAndHrefAndArtistName) == true) {
							continue;
						}
						String xiamiName = xiamiNameAndHrefAndArtistName
								.split("#,#")[0];
						String xiamiArtist = xiamiNameAndHrefAndArtistName
								.split("#,#")[2];
						// 歌名匹配
						String xiamiSongFilter = Utils
								.replaceSpecStr(xiamiName);
						if ((YYTsongNameFilter.toLowerCase()
								.contains(xiamiSongFilter.toLowerCase()))) {
							matchStatus = FinalMatchStatusEnum.FOUR;
							// 音悦台包含虾米，取当前虾米歌曲链接
							xiamiHref = xiamiNameAndHrefAndArtistName
									.split("#,#")[1];
							xiamiMatchName = xiamiName;
							finalXiamiArtist = xiamiArtist;
							break;
						}
					}
					if (matchStatus == FinalMatchStatusEnum.FOUR) {
						break;
					}

					// 虾米音乐歌名包含音悦台歌名
					for (String xiamiNameAndHrefAndArtistName : xiamiSongList) {
						if (Utils.isBlank(xiamiNameAndHrefAndArtistName) == true) {
							continue;
						}
						String xiamiName = xiamiNameAndHrefAndArtistName
								.split("#,#")[0];
						String xiamiArtist = xiamiNameAndHrefAndArtistName
								.split("#,#")[2];
						// 歌名匹配
						String xiamiSongFilter = Utils
								.replaceSpecStr(xiamiName);
						if ((xiamiSongFilter.toLowerCase()
								.contains(YYTsongNameFilter.toLowerCase()))) {
							matchStatus = FinalMatchStatusEnum.THREE;
							// 虾米包含音悦台，取当前虾米歌曲链接
							xiamiHref = xiamiNameAndHrefAndArtistName
									.split("#,#")[1];
							xiamiMatchName = xiamiName;
							finalXiamiArtist = xiamiArtist;
							break;
						}
					}
					if (matchStatus == FinalMatchStatusEnum.THREE) {
						break;
					}

					// 未匹配
					if (matchStatus == FinalMatchStatusEnum.ZERO) {
						break;
					}
				}
				if (matchStatus == FinalMatchStatusEnum.ZERO) {
					continue;
				}

				String reg = "http://.*";
				if (!xiamiHref.matches(reg)) {
					xiamiHref = doc.select("[class=result_main]").select(
							"[class=track_list]").select("tbody").get(0)
							.select("tr").get(0).select("[class=song_name]")
							.select("a").get(1).attr("href");
				}

				*/
/*
				 * 歌曲详情请求
				 *//*

				Document doc1 = Utils.getDocument(xiamiHref);
				Elements elements3 = doc1.select("[class=acts]");
				String elements;
				if (elements3.toString().length() == 0) {
					elements = doc1.select("[class=mgt10]").select(
							"[class=aside_title]").select("span").select("a")
							.attr("href");
				} else {
					elements = doc1.select("[class=acts]").get(1).select("a")
							.attr("href");
				}
				String secondUrl = "";
				if (elements.matches(reg)) {
					secondUrl = elements;
				} else {
					secondUrl = "http://www.xiami.com" + elements;
				}

				*/
/*
				 * 歌曲标签页面请求
				 *//*

				Document doc2 = Utils.getDocument(secondUrl);
				if (doc2 == null) {
					continue;
				}

				Elements tagsSpanList = doc2.select(
						"[class=tag_cloud][id=tag_cloud]").select("span");
				String tagsList = tagsSpanList.select("a").text();
				if (tagsList == null) {
					tagsList = "";
				}

				*/
/*
				 * excel写入工作
				 *//*


				// 音悦台请求路径
				String yYTUrl = "http://v.yinyuetai.com/video/"
						+ songList.get(i).split("!@#")[0];

				// 虾米音乐请求路径
				String xiamiUrl = xiamiHref;

				// 音悦台歌曲Id
				String videoId = songList.get(i).split("!@#")[0];

				// 音悦台歌曲名
				String yytSongName = songList.get(i).split("!@#")[1];

				// 音悦台艺人Id与姓名
				String artistNameAndId = songList.get(i).split("!@#")[2];

				// 虾米音乐匹配名
				String YYTsongName = xiamiMatchName;

				// 标签
				String tagList = tagsList;

				// 一级分类id
				String levelOneCataId = songList.get(i).split("!@#")[3];

				// 二级分类id
				String levelTwoCataId = songList.get(i).split("!@#")[4];

				// 三级分类id
				String levelThreeCataId = songList.get(i).split("!@#")[5];

				// 匹配状态
				String matchStatusName = matchStatus.name;

				// 虾米艺人名
				String xiamiArtistName = finalXiamiArtist;

				String[] arr = { yYTUrl, xiamiUrl, videoId, yytSongName,
						artistNameAndId, YYTsongName, tagList, levelOneCataId,
						levelTwoCataId, levelThreeCataId, matchStatusName,
						xiamiArtistName };
				excelCounts++;
				for (int s = 0; s < 12; s++) {
					Label label = new Label(s, excelCounts, arr[s]);
					ws.addCell(label);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		wb.write();
		wb.close();

	}
}
*/
