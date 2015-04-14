package com.cwind.algorithm;

public class Queens {
	private int[][] chessboard = new int[8][8];
	
	private boolean check(int row, int column) {
		if(row==1){
			return true;
		}
		for(int i=0; i<=row-2; i++){
			if(chessboard[i][column-1]==1) {
				return false;
			}
		}
		int x = row-2;
		int y = column-2;
		while(x>=0&&y>=0){
			if(chessboard[x][y]==1){
				return false;
			}
			x--;
			y--;
		}
		x = row-2;
		y = column;
		while(x>=0&&y<=7){
			if(chessboard[x][y]==1){
				return false;
			}
			x--;
			y++;
		}
		return true;
	}
	
	private void print(){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++) {
				System.out.print(chessboard[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private void backtrack(int row) {
		for(int j=0; j<8; j++) {
			chessboard[row-1][j] = 1;

			if(check(row, j+1)){
				if(row==8) {
					print();
				}else{
					backtrack(row+1);
				}
			}
			
			chessboard[row-1][j] = 0;
		}
	}
	
	public static void main(String[] args) {
		(new Queens()).backtrack(1);
	}
}
