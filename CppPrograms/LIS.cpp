#include <bits/stdc++.h>

using namespace std;

const int INF = 1000000007;

int n, dp[300001], pos[300001], pre[300001], len;
vector<int> v;

int bin_search(int x) {
    int l = 0, r = n + 1;
    while (r - l > 1) {
        int m = (r + l) / 2;
        if (dp[m] >= x) {
            r = m;
        } else {
            l = m;
        }
    }
    return r;
}

int main() {
    freopen("lis.in", "r", stdin);
    freopen("lis.out", "w", stdout);
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int x;
        cin >> x;
        v.push_back(x);
    }
    len = 0;
    dp[0] = -INF;
    for (int i = 1; i <= n; ++i) {
        dp[i] = INF;
    }
    pos[0] = -1;
    for (int i = 0; i < n; ++i) {
        int p = bin_search(v[i]);
        if (dp[p - 1] < v[i] && v[i] < dp[p]) {
            dp[p] = v[i];
            pos[p] = i;
            pre[i] = pos[p - 1];
            len = max(len, p);
        }
    }
    vector<int> ans;
    int p = pos[len];
    while (p != -1) {
        ans.push_back(v[p]);
        p = pre[p];
    }
    reverse(ans.begin(), ans.end());
    cout << ans.size() << endl;
    for (int i = 0; i < (int)ans.size(); ++i) {
        cout << ans[i] << ' ';
    }
    return 0;
}
