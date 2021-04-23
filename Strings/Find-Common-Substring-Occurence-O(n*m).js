
/**
 * Runtime Complexity: O (n * m)
 * Space Complexity: O(1)
 */

let findCommonSubstring = function(str1, str2) {
        var count = 0;
        for (let i = 0; i < str1.length;) {
                if (str2[0] === str1[i]) {
                        let j = 1;
                        let charCount = 1;
                        i++;
                        while (j < str2.length) {
                                if (str2[j] === str1[i]) {
                                        charCount++;
                                }
                                j++;
                                i++;
                        }
                        // Check if substring was found
                        if (charCount === str2.length) {
                                count++;
                        }
                } else {
                        i++;
                }
                
        }

        return count;
}

//
console.log(findCommonSubstring('TiplaysTilaughsTimeeatsTirunsTi', 'Tim')); // 4