package keyboardEvents;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class WhatKey {

	public static class MyKeyListener implements KeyListener {

		public void keyPressed(KeyEvent e) {
			System.out.printf("Typed: %c\n", e.getKeyChar());
		}

		public void keyTyped(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}

	}

	public static void main(String[] args) {
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 200;

		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("What Key?");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addKeyListener(new MyKeyListener());
		frame.setVisible(true);
	}

}
