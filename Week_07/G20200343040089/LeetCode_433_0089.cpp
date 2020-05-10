//	Search using bidirectional BFS
class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {
        unordered_set<string> candidte(bank.begin(), bank.end());
        if (candidte.find(end) == candidte.end()) return -1;
        unordered_set<string> beginSet, endSet, *pbegin, *pend;
        beginSet.insert(start);
        endSet.insert(end);
        int step = 0;
        int L = start.size();

        while (!beginSet.empty() && !endSet.empty()) {
            if (beginSet.size() <= endSet.size()) {
                pbegin = &beginSet;
                pend = &endSet;
            } else {
                pbegin = &endSet;
                pend = &beginSet;
            }
            unordered_set<string> temp;
            step++;
            for (auto itr = pbegin->begin(); itr != pbegin->end(); ++itr) {
                for (int i = 0; i < L; ++i) {
                    string gene = *itr;
                    for (char g : "ACGT") {
                        gene[i] = g;
                        if (pend->find(gene) != pend->end()) return step;
                        if (candidte.find(gene) != candidte.end()) {
                            temp.insert(gene);
                            candidte.erase(gene);
                        }
                    }
                }
            }
            pbegin->swap(temp);
        }
        return -1;
    }
};