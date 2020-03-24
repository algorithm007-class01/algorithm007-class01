public class Solution
{
    public IList<IList<string>> GroupAnagrams(string[] strs)
    {
        if (strs.Length == 0) return null;
        Dictionary<string, List<string>> ans = new Dictionary<string, List<string>>();
        foreach (var s in strs)
        {
            char[] ca = s.ToCharArray().OrderBy(x => x).ToArray();
            string key = String.Concat(ca);
            if (!ans.ContainsKey(key)) ans.Add(key, new List<string>());
            ans.GetValueOrDefault(key).Add(s);
        }
        return ans.Select(x => x.Value).ToArray();
    }
}