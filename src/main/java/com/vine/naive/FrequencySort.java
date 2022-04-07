package com.vine.naive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 阿季
 * @date 2020-06-29 2:28 PM
 */

public class FrequencySort {
    public String frequencySort(String s) {
        if (Objects.isNull(s)) {
            return null;
        }
        char[] chars = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            String key = String.valueOf(aChar);
            Integer value = map.get(key);
            if (Objects.isNull(value)) {
                map.put(key, 1);
            } else {
                map.put(key, ++value);
            }
        }
        List<Map.Entry<String, Integer>> list = map.entrySet()
                .stream()
                .sorted((entry1, entry2) -> - entry1.getValue().compareTo(entry2.getValue()))
                .collect(Collectors.toList());

        String result = new String();
        for (Map.Entry<String, Integer> item : list) {
            String key = item.getKey();
            Integer value = item.getValue();
            for (Integer i = 0; i < value; i++) {
                result += key;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        frequencySort.frequencySort("tree");
    }
}
















