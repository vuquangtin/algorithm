package algorithm.docs.md.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
	public enum TITLE {
		algorithm(1), cses(2), java(3), github(4), java_certification(5), docs(6);
		private int index;

		private TITLE(int index) {
			this.index = index;
		}

		public static TITLE getMe(int index) {
			for (TITLE item : TITLE.values()) {
				if (item.index == index)
					return item;
			}
			return null;
		}
	}

	HashMap<TITLE, Set<String>> hash;

	public void updateReadme() {
		
	}

	public static void main(String[] args) {
		UpdateREADME upd = new UpdateREADME();
		upd.loadReadme();
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
				} else {
					if (hash.get(TITLE.getMe(index)) == null) {
						HashSet<String> set = new HashSet<>();
						set.add(line);
						hash.put(TITLE.getMe(index), set);
					} else {
						hash.get(TITLE.getMe(index)).add(line);
					}
				}

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
