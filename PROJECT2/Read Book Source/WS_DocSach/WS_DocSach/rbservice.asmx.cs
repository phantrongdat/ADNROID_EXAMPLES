using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using WS_DocSach.Models;

namespace WS_DocSach
{
    /// <summary>
    /// Summary description for rbservice
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class rbservice : System.Web.Services.WebService
    {
        RBModelDataContext db = new RBModelDataContext();

        [WebMethod]
        public List<Sach> LaySachMoiNhat()
        {
            return db.Saches.ToList();
        }
        [WebMethod]
        public List<Sach> LaySachXemNhieu()
        {
            return db.Saches.OrderByDescending(m => m.LuotXem).ToList();
        }

        [WebMethod]
        public List<Sach> LaySachYeuThich()
        {
            return db.Saches.OrderByDescending(m => m.YeuThich).ToList();
        }

        //[WebMethod]
        //public List<Sach> LaySachDocNhieu()
        //{
        //    return db.Saches.OrderByDescending(m => m.LuotDoc).ToList();
        //}
        [WebMethod]
        public List<Sach> LaySachTheoChuyenMuc(int id)
        {
            return db.Saches.Where(m => m.MaChuyenMuc == id).ToList();
        }
        [WebMethod]
        public List<Sach> LaySachTheoNhaXuatBan(int id)
        {
            return db.Saches.Where(m => m.MaNhaXuatBan == id).ToList();
        }
        [WebMethod]
        public List<Sach> LaySachLienQuan(int id)
        {
            return db.Saches.Where(m => m.MaChuyenMuc == id).ToList();
        }

        [WebMethod]
        public Sach LayChiTietSach(int id)
        {
            return db.Saches.SingleOrDefault(m => m.MaSach == id);
        }
        [WebMethod]
        public List<Chuong> LayDanhSachChuong(int id)
        {
            var sach=db.Saches.SingleOrDefault(m => m.MaSach == id);
            sach.LuotXem++;
            db.SubmitChanges();
            return db.Chuongs.Where(m => m.MaSach == id).ToList();
        }

        [WebMethod]
        public List<Sach> SachYeuThich(int id)
        {
            var sach = db.Saches.SingleOrDefault(m => m.MaSach == id);
            sach.YeuThich++;
            db.SubmitChanges();
            return db.Saches.ToList();
        }
        
        [WebMethod]
        public List<Sach> TimKiemSach(string text)
        {
            return db.Saches.Where(m => m.TenSach.ToLower().Contains(text.ToLower()) || m.NhaXuatBan.TenNhaXuatBan.ToLower().Contains(text.ToLower())).ToList();
        }

        [WebMethod]
        public List<ChuyenMuc> LayChuyenMuc()
        {
            return db.ChuyenMucs.ToList();
        }
    }
}
