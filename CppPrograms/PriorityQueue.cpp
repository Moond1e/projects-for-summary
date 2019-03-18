#include <bits/stdc++.h>

using namespace std;

int a[300001], ind[300001], p[300001], sz, cur;

void swapp(int x, int y) {
    swap(a[x], a[y]);
    swap(ind[p[x]], ind[p[y]]);
    swap(p[x], p[y]);
}

void sift_up(int x) {
    while (x > 1 && a[x] < a[x / 2]) {
        swapp(x, x / 2);
        x /= 2;
    }
}

void sift_down(int x) {
    while (x < sz) {
        if (2 * x > sz) {
            break;
        }
        if (2 * x + 1  > sz) {
            if (a[2 * x] < a[x]) {
                swapp(x, 2 * x);
            }
            break;
        }
        if (a[x] <= a[2 * x] && a[x] <= a[2 * x + 1]) {
            break;
        }
        int y = 2 * x;
        if (a[2 * x] > a[2 * x + 1]) {
            y = 2 * x + 1;
        }
        swapp(x, y);
        x = y;
    }
}

void push(int x) {
    ++sz;
    p[sz] = cur;
    ind[cur] = sz;
    a[sz] = x;
    sift_up(sz);
}

void extract_min() {
    if (sz == 0) {
        cout << "*" << endl;
        return;
    }
    ind[p[1]] = -1;
    int ansn = a[1];
    int ansi = p[1];
    a[1] = a[sz];
    p[1] = p[sz];
    sz--;
    ind[p[1]] = 1;
    sift_down(1);
    cout << ansn << ' ' << ansi << endl;
}

void decrease_key(int x, int v) {
    if (ind[x] == -1) {
        ++cur;
    } else {
        a[ind[x]] = v;
        sift_up(ind[x]);
    }
}

int main() {
    freopen("priorityqueue2.in", "r", stdin);
    freopen("priorityqueue2.out", "w", stdout);
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    string s;
    cur = 1;
    sz = 0;
    while (cin >> s) {
        if (s[0] == 'p') {
            int x;
            cin >> x;
            push(x);
        }
        if (s[0] == 'e') {
            extract_min();
        }
        if (s[0] == 'd') {
            int x, v;
            cin >> x >> v;
            decrease_key(x, v);
        }
        ++cur;
    }
    return 0;
}
