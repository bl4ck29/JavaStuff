public class NhanVien {
	public String MS, Ten, ChucVu, DiaChi;
	public int Luong;
	public NhanVien(String MS, String Ten, String ChucVu, String DiaChi, int Luong) {
		this.MS = MS;
		this.Ten = Ten;
		this.ChucVu = ChucVu;
		this.DiaChi = DiaChi;
		this.Luong = Luong;
	}
	String ToString() {
		return(this.MS+","+this.Ten+","+this.ChucVu+","+this.DiaChi+","+this.Luong);
	}
}
