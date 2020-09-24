package algorithm.docs.md.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import algorithm.utilities.Log4jUtils;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/

 *      vuquangtin/algorithm</a>
 *
 */
public class UpdateREADME {
	private static Logger logger = Logger.getLogger(UpdateREADME.class
			.getName());
	private static int INDEX_TITLE = 1;

	public enum TITLE {
		algorithm(
				INDEX_TITLE++,
				"# algorithm",
				"Giải thuật Algorithms (hay còn gọi là thuật toán) là một tập hợp hữu hạn các chỉ thị để được thực thi theo một thứ tự nào đó để thu được kết quả mong muốn. Nói chung thì giải thuật là độc lập với các ngôn ngữ lập trình, tức là một giải thuật có thể được triển khai trong nhiều ngôn ngữ lập trình khác nhau.\nXuất phát từ quan điểm của cấu trúc dữ liệu, dưới đây là một số giải thuật quan trọng:"
						+ "\n\n* Giải thuật Tìm kiếm: Giải thuật để tìm kiếm một phần tử trong một cấu trúc dữ liệu."
						+ "\n* Giải thuật Sắp xếp: Giải thuật để sắp xếp các phần tử theo thứ tự nào đó."
						+ "\n* Giải thuật Chèn: Giải thuật để chèn phần từ vào trong một cấu trúc dữ liệu."
						+ "\n* Giải thuật Cập nhật: Giải thuật để cập nhật (hay update) một phần tử đã tồn tại trong một cấu trúc dữ liệu."
						+ "\n* Giải thuật Xóa: Giải thuật để xóa một phần tử đang tồn tại từ một cấu trúc dữ liệu."
						+ "\n\n## Tham khảo"), cses(INDEX_TITLE++, "# cses",
				"\n\n## Tham khảo"), icpc(INDEX_TITLE++, "# icpc",
				"\n\n## Tham khảo"), java(INDEX_TITLE++, "# java",
				"\n\n## Tham khảo"), github(INDEX_TITLE++, "# github",
				"\n\n## Tham khảo"), java_certification(INDEX_TITLE++,
				"# java_certification", "\n\n## Tham khảo"), Exam(
				INDEX_TITLE++, "# Exam", "\n\n## Tham khảo"), docs(
				INDEX_TITLE++, "# docs", "\n\n## Tham khảo");
		private int index;
		private String name;
		private String des;

		private TITLE(int index, String name, String des) {
			this.index = index;
			this.name = name;
			this.des = des;
		}

		public static TITLE getMe(int index) {
			for (TITLE item : TITLE.values()) {
				if (item.index == index)
					return item;
			}
			return null;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDes() {
			return des;
		}

		public void setDes(String des) {
			this.des = des;
		}
	}

	HashMap<TITLE, Set<String>> hash;

	public void updateReadme() {
		for (TITLE item : TITLE.values()) {
			update(item);
		}
	}

	void update(TITLE title) {
		switch (title) {
		case algorithm:
			hash.get(title).addAll(updateAlgorithm());
			break;
		case cses:
			hash.get(title).addAll(updateCses());
			break;
		case docs:
			hash.get(title).addAll(updateDocs());
			break;
		case github:
			hash.get(title).addAll(updateGithub());
			break;
		case java:
			hash.get(title).addAll(updateJava());
			break;
		case java_certification:
			hash.get(title).addAll(updateJavaCertification());
			break;
		case icpc:
			hash.get(title).addAll(updateIcpc());
			break;
		case Exam:
			hash.get(title).addAll(updateExam());
			break;
		default:
			break;

		}
	}

	private Collection<? extends String> updateExam() {
		Set<String> set = new HashSet<String>();
		set.add("https://github.com/smholsen/HackerRank/blob/master/readme.md");
		set.add("https://github.com/hd132607/JavaPractice/blob/master/README.md");
		set.add("https://github.com/ByoungJoonIm/Algorithm_Practice/tree/master");
		set.add("https://github.com/AkshantVats/Patterns_For_Coding_interview");
		set.add("https://github.com/search?l=Markdown&p=4&q=java+practice&type=Code");
		set.add("https://javabeat.net/ocpjp-6-mock-exam-java-9/");
		return set;
	}

	private Collection<? extends String> updateIcpc() {
		Set<String> set = new HashSet<String>();
		set.add("https://github.com/matthewsamuel95/ACM-ICPC-Algorithms");
		set.add("http://www.olp.vn/luu-tru/2005");
		set.add("http://www.olp.vn/thi-sinh");

		set.add("https://v1study.com/giai-thuat-va-lap-trinh-phuong-phap-sinh-generation.html");
		return set;
	}

	private Collection<? extends String> updateGithub() {
		Set<String> set = new HashSet<String>();
		set.add("https://github.com/PeterXiao/jmh-sample-and-java8-current/tree/master/src/main/java/versions/java8/concurrence");
		set.add("https://github.com/sea-boat/java_concurrent/tree/master/src/main/java/com/seaboat/thread");
		set.add("https://github.com/balajinima/java-concurrency/tree/master ");
		set.add("https://github.com/omar391/JavaAdvanced/tree/master/src/main/java/com/astronlab/tut/concurrency/intermediate ");
		set.add("https://github.com/sandysanthosh/Java-Interview-Programs ");
		set.add("https://github.com/koushikmalla/koushik-java/blob/c5272853a5a690a987f777a12a1b8aea61df88aa/README.md ");
		set.add("https://github.com/jjfiv/ds4j/tree/master/src ");
		set.add("https://github.com/tejaswigk/tejaswigk.github.io/blob/master/_posts/2020-02-14-40-java-collections-interview.md ");
		set.add("https://github.com/rkavs/learnJava/blob/master/interview-questions.md ");
		set.add("https://github.com/hello-chenchen/design-patterns/blob/master/README.md ");
		set.add("https://github.com/dharmesh0500/design-patterns/tree/master ");
		set.add("https://github.com/manish24-tech/Java-Object-Oriented-Design-Pattern  ");
		set.add("https://github.com/thanghoang07/java/tree/master ");
		set.add("https://github.com/AMBE1203/algorithms ");
		set.add("https://github.com/nvduong97/Data-structure-and-algorithm/tree/master/Intership%20SamSung%20SVMC ");
		set.add("https://github.com/elvis-kaito/Algorithm-IT3680/tree/master ");
		set.add("https://github.com/jmanhnv/java-tricks ");
		set.add("https://github.com/nguyenvanquang98/LTDT-/tree/master ");
		return set;
	}

	private Collection<? extends String> updateJava() {
		Set<String> set = new HashSet<String>();
		set.add("https://sites.google.com/site/cse423fall2018/tai-lieu-mon-hoc");
		set.add("http://uet.vnu.edu.vn/~chauttm/TDD/");
		return set;
	}

	private Collection<? extends String> updateJavaCertification() {
		Set<String> set = new HashSet<String>();
		set.add("https://github.com/dhananjaygandhi/books/tree/master/SCJP");
		set.add("https://github.com/springapidev/java-certification");
		set.add("https://github.com/lxnhiqn905/java-learning");
		set.add("https://github.com/Joshal1990/java-certification");
		set.add("https://github.com/saurabhpro/Java-Certification");
		set.add("https://github.com/springapidev/java-certification");
		set.add("https://github.com/bambrikii/java-certification");
		set.add("https://github.com/MohamedDhiaJemai/Books-to-Prepare-Oracle-Java-Certification-Exams");
		set.add("https://github.com/dfreniche/oca-java8-notes");
		set.add("https://github.com/mariazevedo88/java-certification-oca");
		set.add("https://github.com/egenerat/java-8-certification");
		set.add("https://github.com/malicktw/java-learning");
		set.add("https://github.com/Cuica20/OCA_1Z0-808");
		set.add("https://github.com/AlexKbit/oracleCertification/tree/master/src/main/java/com");
		set.add("https://github.com/MegaMinds101/Elearning/tree/master/Elearn/data/db/pdf");
		set.add("https://github.com/horiajurcut/coding-interview/blob/master/notes/cracking-the-code-interview/contents.md");
		set.add("https://github.com/sunaina153/BuildingBytes/tree/master/build/web/book");
		set.add("https://github.com/spygi/tech-blog/blob/master/_posts/2018-08-29-Java.markdown");
		set.add("https://github.com/rachitvk/ebooks/blob/master/README.md");
		set.add("https://github.com/KaiDevNotes/notes/tree/master/Java");
		set.add("https://github.com/hattallipuneet/Self-Prep/blob/master/Multithreading%20Notes");
		set.add("https://github.com/sethhardik/e-books/blob/master/README.md");
		set.add("https://github.com/dhananjaygandhi/books");
		set.add("https://github.com/ReidHershell/SCJP-Sun-Certified-Programmer-for-Java-Study-Guide-");
		set.add("https://github.com/muazzam27/interview_questions/blob/master/README.md");

		set.add("https://github.com/ShengzhenFu/doc_hub/tree/master/content/Big-Data");
		set.add("https://github.com/adhikariaman01/BookmarkSiteList/blob/master/MyBookmarkedLink/Java/README.md");
		set.add("https://github.com/EugenePodovinnikov/OCA");
		set.add("https://github.com/mekanhan/JavaCertificationPrep/tree/master/src/BasicControlFlow");
		set.add("https://github.com/SumeyyaSabanci/OCA_Studies/tree/master/src");
		set.add("https://github.com/I-HSUN/JAVA_EX");
		set.add("https://github.com/marcelam70/JavaTest/tree/master/src");
		set.add("https://github.com/darixsamani/engine-search-book/blob/a459aff808d0dc0e6c6a854016e12720c748397d/resultats.csv");
		set.add("https://javaconceptoftheday.com/");

		return set;
	}

	private Collection<? extends String> updateDocs() {
		Set<String> set = new HashSet<String>();
		set.add("https://github.com/namhoangduc99/TargetOf2018/blob/master/TLCL-09.12.pdf ");
		set.add("https://github.com/finn-nguyen/Ebook ");
		set.add("https://kienthuc24h.com/tong-hop-tai-lieu-chuyen-tin-can-thiet/");
		set.add("https://chuyen-qb.com/web/tochuyenmon/tin/thuvien");
		set.add("https://github.com/abhinavkorpal/awesome-computer-science-EBook/tree/master/Java ");
		set.add("https://github.com/NickVBi/OCA-Java-SE-8-Programmer-I-Study-Guide/tree/master ");
		set.add("https://github.com/cjarroyo/oca8 ");

		set.add("https://github.com/smokecoffee/EBooks ");
		set.add("https://github.com/Innsmounth/JavaEBooks ");

		set.add("https://www.ossblog.org/learn-java-programming-with-excellent-open-source-books/ ");
		set.add("https://github.com/smokecoffee/documentation ");
		set.add("https://github.com/smokecoffee/ocpj8-notes ");

		set.add("https://drive.google.com/drive/folders/0B6aHy9Nd8VFib3NvU0c2SWlGalk ");
		set.add("https://sites.google.com/site/lophocproptit/ ");
		set.add("https://www.giaithuatlaptrinh.com/?p=553 ");
		set.add("https://cowboycoder.tech/spoj/spoj-vmpizza-pizza ");
		set.add("https://github.com/29ff/advanced_node/tree/master");

		set.add("https://github.com/vmmurthy/tech-docs");
		set.add("https://github.com/boxxv/boxxv.github.io/tree/master/_posts");
		set.add("https://github.com/TapNhamBlog/TapNhamBlog.github.io/tree/master/_posts");

		set.add("https://github.com/1653072/ZalopayFresher");
		set.add("https://github.com/toanph-github/Tutorial");
		set.add("https://github.com/toanph-github/Tutorial");

		set.add("https://github.com/minhduc2803/fresher-program-2020");
		set.add("https://github.com/ahsandar/smtebooks-scrapper/tree/master/book_list/programming-it");
		set.add("https://github.com/EugenePodovinnikov/OCA/tree/master");

		set.add("https://github.com/minhduc2803/fresher-program-2020/blob/dev/submissions/module-01/phucvt/docs/1.3-docker/1.3-docker.md");
		return set;
	}

	private Collection<? extends String> updateCses() {
		Set<String> set = new HashSet<String>();
		set.add("https://cses.fi/problemset/  ");
		set.add("https://github.com/truongcongthanh2000/CSES-Solutions  ");
		set.add("https://github.com/thcy/CSES-Solutions/tree/master   ");
		set.add("https://github.com/ShivamS72/CSES/tree/master   ");
		set.add("https://github.com/tonymontaro/java-algos   ");
		set.add("https://github.com/tonymontaro/java-algos/tree/master/src/CSES_FI ");
		set.add("https://github.com/Dhruv414/CSESProblems   ");
		set.add("https://github.com/liwen-tj/java-code/tree/master/cses  ");
		return set;
	}

	private Collection<? extends String> updateAlgorithm() {
		Set<String> set = new HashSet<String>();
		set.add("https://drive.google.com/file/d/1Be4gVjW5gK8wqg0NifCptKYBd7cHyoSW/edit ");
		set.add("https://github.com/GauravWalia19/Free-Algorithms-Books ");
		set.add("https://github.com/smokecoffee/Big-O ");
		set.add("https://vnoi.info/wiki/translate/topcoder/How-to-Find-a-Solution.md ");
		set.add("https://github.com/manhcntt21/Application-Algorithms--SamSung ");
		set.add("http://vnoi.info/wiki/algo/basic/Tai-Lieu-Thuat-Toan.md ");
		set.add("https://github.com/hieptran1812/Algorithm-for-ITPTIT ");
		set.add("https://github.com/cullen2205/https-www.spoj.com-ABC2019 ");
		set.add("https://github.com/lamtt2403/KTLTHDT ");
		set.add("https://github.com/nguyenvandai61/DiscreteMath ");
		set.add("https://github.com/AMBE1203/algorithms ");
		set.add("https://github.com/thongbkvn/Project1 ");
		set.add("https://e16cn-ptit.blogspot.com/search/label/PTIT%20SPOJ?max-results=6 ");
		set.add("https://cowboycoder.tech/categories/spoj/ ");
		set.add("https://kienthuc24h.com/category/thuat-toan/ ");
		set.add("https://v1study.com/giai-thuat-va-lap-trinh-loi-mo-dau.html ");
		set.add("https://www.spoj.com/PTIT/ ");
		set.add("https://www.spoj.com/ACMPTIT/problems/main/sort=0,start=0");
		set.add("https://github.com/VikasSherawat/Programming/tree/master/CompanyInterviews ");
		set.add("https://github.com/vunguyen1989/Fundamental/tree/master/LeMinhHoang");
		return set;
	}

	public static void main(String[] args) {
		logger = Log4jUtils.initLog4j();
		UpdateREADME upd = new UpdateREADME();
		// upd.loadReadme();
		upd.intReadme();
		upd.updateReadme();
		upd.saveReadme();
	}

	PrintWriter out;

	private void saveReadme() {
		try {
			out = ReadMe.loadOutput();
			boolean isFirst = true;
			for (TITLE item : TITLE.values()) {
				if (hash.get(item) != null) {
					if (!isFirst)
						print("\n");
					else
						isFirst = false;
					println(item.getName());
					println(item.getDes());
					print("\n");
					logger.debug(item.getDes());
					for (String itemStr : hash.get(item)) {
						// logger.debug(itemStr);
						itemStr = itemStr.trim();
						if (itemStr.startsWith("https")) {
							logger.debug("* [" + itemStr + "](" + itemStr + ")");
							println("* [" + itemStr + "](" + itemStr + ")");
						} else {
							// println(itemStr);
						}
					}
				}

			}
			out.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void intReadme() {
		hash = new HashMap<UpdateREADME.TITLE, Set<String>>();
		for (TITLE title : TITLE.values()) {
			HashSet<String> set = new HashSet<>();
			set.add(title.name);
			hash.put(title, set);
		}

	}

	public void loadReadme() {
		hash = new HashMap<UpdateREADME.TITLE, Set<String>>();
		try {
			BufferedReader br = ReadMe.loadInput();
			int index = 0;
			while (br.ready()) {
				String line = br.readLine();
				System.out.println(line);
				if (line.startsWith("#")) {
					index++;
					if (hash.get(TITLE.getMe(index)) == null) {
						HashSet<String> set = new HashSet<>();
						// set.add(line);
						hash.put(TITLE.getMe(index), set);
					}
				} else {

					hash.get(TITLE.getMe(index)).add(line);

				}

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void println(Object inp) {
		out.println(inp);
	}

	public void print(Object inp) {
		out.print(inp);
	}
}
