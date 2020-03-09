package checker;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class board extends Canvas {

	int[][] A = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 3, 1, 1, 1, 1, 1, 1, 1, 4, 0, 0, 0, 0 },
			{ 0, 0, 0, 3, 3, 1, 1, 1, 1, 1, 1, 4, 4, 0, 0, 0, 0 },
			{ 0, 0, 3, 3, 3, 1, 1, 1, 1, 1, 4, 4, 4, 0, 0, 0, 0 },
			{ 0, 3, 3, 3, 3, 1, 1, 1, 1, 4, 4, 4, 4, 0, 0, 0, 0 },
			{ 3, 3, 3, 3, 3, 1, 1, 1, 4, 4, 4, 4, 4, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	/*
	 * int[][] A = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, { 0, 0,
	 * 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0,
	 * 0, 1, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0
	 * }, { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 3, 1, 3, 3, 3, 3 }, { 0, 0, 0, 0, 1, 1,
	 * 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 0 }, { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 3,
	 * 3, 3, 0, 0 }, { 0, 0, 0, 0, 1, 1, 1, 1, 4, 1, 1, 1, 3, 3, 0, 0, 0 }, { 0, 0,
	 * 0, 0, 1, 1, 1, 1, 4, 1, 1, 1, 3, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1, 1, 1, 1,
	 * 1, 1, 4, 4, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 0, 0, 0, 0
	 * }, { 0, 1, 1, 1, 2, 1, 1, 1, 1, 4, 4, 4, 4, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 2,
	 * 2, 2, 2, 4, 4, 4, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0,
	 * 0, 0, 0, 0 }, { 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0,
	 * 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 2, 0, 0, 0, 0,
	 * 0, 0, 0, 0, 0, 0, 0, 0 } };
	 */

	int[][][] goal = {
			{ { 13, 4 }, { 14, 4 }, { 15, 4 }, { 16, 4 }, { 13, 5 }, { 14, 5 }, { 15, 5 }, { 13, 6 }, { 14, 6 },
					{ 12, 7 }, { 13, 7 }, { 12, 8 }, { 12, 6 }, { 12, 5 }, { 12, 4 } },
			{ { 4, 12 }, { 5, 12 }, { 6, 12 }, { 7, 12 }, { 8, 12 }, { 4, 13 }, { 5, 13 }, { 6, 13 }, { 7, 13 },
					{ 4, 14 }, { 5, 14 }, { 6, 14 }, { 4, 15 }, { 5, 15 }, { 4, 16 } },
			{ { 4, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 4, 8 }, { 5, 4 }, { 5, 7 }, { 5, 5 }, { 5, 6 }, { 6, 4 },
					{ 6, 5 }, { 6, 6 }, { 7, 4 }, { 7, 5 }, { 8, 4 } } };
	double l = 40;
	double dx = l * Math.cos(60 * Math.PI / 180);
	double dy = l * Math.sin(60 * Math.PI / 180);
	int r = 5;
	Point p0 = new Point();
	public static int mark = 0;
	int i_old, j_old;
	board b;
	checker app;
	win w;

	int[][] move_jump = { { -2, 0 }, { 2, 0 }, { 0, -2 }, { 0, 2 }, { -2, 2 }, { 2, -2 } };
	int[][] move_step = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 1 }, { 1, -1 } };

	void clearmark() {
		int i, j;
		for (i = 0; i < 17; i++)
			for (j = 0; j < 17; j++) {
				if (A[i][j] > 4)
					A[i][j] = 1;
			}
		repaint();
	}

	void possiblemove(int i, int j) {
		int k, l;
		for (int m = 0; m < 6; m++) {
			k = i + move_jump[m][0];
			l = j + move_jump[m][1];
			if (k >= 0 && l >= 0 && k < 17 && l < 17)
				if (ismovable(i, j, k, l)) {
					A[k][l] = 5;
					possiblemove(k, l);
				}
			k = i + move_step[m][0];
			l = j + move_step[m][1];
			if (k >= 0 && l >= 0 && k < 17 && l < 17)
				if (ismovable(i, j, k, l) && A[i][j] != 5) {
					A[k][l] = 5;
				}

		}

		repaint();
	}

	boolean ismovable(int i, int j, int k, int l) {
		if (A[i][j] > 1 && A[k][l] == 1) {
			if ((k == i - 1 && l == j) || (k == i + 1 && l == j) || (k == i && l == j - 1) || (k == i && l == j + 1)
					|| (k == i - 1 && l == j + 1) || (k == i + 1 && l == j - 1))
				return true;
		}
		if (A[i][j] > 1 && A[k][l] == 1) {
			if ((k == i - 1 && l == j) || (k == i + 1 && l == j) || (k == i && l == j - 1) || (k == i && l == j + 1)
					|| (k == i - 1 && l == j + 1) || (k == i + 1 && l == j - 1))
				return true;
			if (((k == i - 2 && l == j) && A[i - 1][l] > 1) || ((k == i + 2 && l == j) && A[i + 1][j] > 1)
					|| ((k == i && l == j - 2) && A[i][j - 1] > 1) || ((k == i && l == j + 2) && A[i][j + 1] > 1)
					|| ((k == i - 2 && l == j + 2) && A[i - 1][j + 1] > 1)
					|| ((k == i + 2 && l == j - 2) && A[i + 1][j - 1] > 1))
				return true;
		}

		return false;
	}

	public board() {

		p0.x = 150;
		p0.y = 40;
		b = this;

		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				int i = (int) Math.round((x - p0.x - (y - p0.y) * dx / dy) / 2 / dx);
				int j = (int) Math.round((y - p0.y) / dy);

				if (A[i][j] == 5) {// ¦Ç¦â ¥i²¾°Ê
					if (mark == w.mycolor) {
						A[i][j] = mark;
						A[i_old][j_old] = 1;
						b.repaint();

						app.myturn = false;
						String ijstring = mark + ",1," + i_old + "," + j_old + "," + i + "," + j;
						new SocketClient(ijstring);
					}

				}
				clearmark();

				checkwin();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (app.myturn && !app.redwon && !app.yellowwon && !app.greenwon) {
					int x = e.getX();
					int y = e.getY();
					int i = (int) Math.round((x - p0.x - (y - p0.y) * dx / dy) / 2 / dx);
					int j = (int) Math.round((y - p0.y) / dy);
					mark = A[i][j];
					if (mark == w.mycolor) {
						i_old = i;
						j_old = j;
						possiblemove(i, j);
						b.repaint();
					} else {
						w.showmessage("Don't touch!");
					}
				} else {
					w.showmessage("No you turn!");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void checkwin() {
		int yellowcount = 0;
		int redcount = 0;
		int greencount = 0;

		System.out.println("check Win start!");

		for (int j = 0; j < 15; j++) {
			if (A[goal[0][j][0]][goal[0][j][1]] == 2) 
				yellowcount++;
		}

		for (int j = 0; j < 15; j++) {
			if (A[goal[1][j][0]][goal[1][j][1]] == 3) 
				redcount++;
		}
		for (int j = 0; j < 15; j++) {
			if (A[goal[2][j][0]][goal[2][j][1]] == 4) 
				greencount++;
		}

		if (yellowcount == 15) {
			app.yellowwon = true;
			win.showmessage("Yellow Win!");
		}
		if (redcount == 15) {
			app.redwon = true;
			win.showmessage("Red Win!");
		}
		if (greencount == 15) {
			app.greenwon = true;
			win.showmessage("Green Win!");
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		final int N = 17;
		int i, j;
		cell c = new cell();
		int x, y;
		for (i = 0; i < N; i++)
			for (j = 0; j < N; j++) {
				if (A[i][j] > 0) {
					x = (int) ((2 * i + j) * dx);
					y = (int) (j * dy);
					c.set(p0.x + x, p0.y + y, A[i][j] - 1);
					c.draw(g);
					g.drawString("(" + i + "," + j + ")", p0.x + x, p0.y + y + r + r + r);
				}
			}

	}

//---------------------------
	boolean set(int i, int j, int player) {
		if (A[i][j] < 1) {
			System.out.println("wrong position");
			return false;
		} else
			A[i][j] = player;
		return true;
	}

	boolean jump(int color, int i, int j, int m, int n) {

		A[m][n] = A[i][j];
		A[i][j] = 1;
		repaint();

		for (int a = 0; a < 17; a++)
			for (int b = 0; b < 17; b++)
				if (A[a][b] == 9 - w.mycolor - color)
					A[a][b] = 1;

		return true;
	}

}

class cell {
	Point p = new Point();
	int r = 10;
	int player = 0;
	final Color[] c = { Color.WHITE, Color.YELLOW, Color.RED, Color.GREEN, Color.GRAY };

	void set(int x, int y, int player) {
		p.x = x;
		p.y = y;
		this.player = player;
	}

	void draw(Graphics g) {
		g.setColor(c[player]);
		g.fillOval(p.x - r, p.y - r, r + r, r + r);
		g.setColor(Color.BLACK);
		g.drawOval(p.x - r, p.y - r, r + r, r + r);
	}

}