-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.33 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for db_kursus
CREATE DATABASE IF NOT EXISTS `db_kursus` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `db_kursus`;

-- Dumping structure for table db_kursus.kelas
CREATE TABLE IF NOT EXISTS `kelas` (
  `kodeKelas` char(5) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `namaKelas` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `kategoriKelas` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`kodeKelas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_kursus.kelas: ~14 rows (approximately)
/*!40000 ALTER TABLE `kelas` DISABLE KEYS */;
INSERT INTO `kelas` (`kodeKelas`, `namaKelas`, `kategoriKelas`) VALUES
	('AK001', 'Dasar Akuntansi', 'Akuntansi'),
	('AK002', 'Jurnal', 'Akuntansi'),
	('AK003', 'Neraca', 'Akuntansi'),
	('AK004', 'Buku Besar', 'Akuntansi'),
	('AK005', 'Laporan Keuangan', 'Akuntansi'),
	('IF001', 'Java Programming', 'Informatika'),
	('IF002', 'Python', 'Informatika'),
	('IF003', 'Basis Data', 'Informatika'),
	('PJ001', 'KUP', 'Perpajakan'),
	('PJ002', 'PPh', 'Perpajakan'),
	('PJ003', 'PPN', 'Perpajakan'),
	('PJ004', 'Akuntansi Pajak', 'Perpajakan'),
	('PW001', 'Studi Destinasi', 'Pariwisata'),
	('PW002', 'Ticketing', 'Pariwisata');
/*!40000 ALTER TABLE `kelas` ENABLE KEYS */;

-- Dumping structure for table db_kursus.pengajar
CREATE TABLE IF NOT EXISTS `pengajar` (
  `kodePengajar` char(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `namaPengajar` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `jkPengajar` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `alamatPengajar` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `teleponPengajar` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`kodePengajar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_kursus.pengajar: ~8 rows (approximately)
/*!40000 ALTER TABLE `pengajar` DISABLE KEYS */;
INSERT INTO `pengajar` (`kodePengajar`, `namaPengajar`, `jkPengajar`, `alamatPengajar`, `teleponPengajar`) VALUES
	('PG001', 'Ismail F', 'Laki-Laki', 'Jl. Ambon 23', '022-6012912'),
	('PG002', 'Irma N', 'Perempuan', 'Jl. RE Martadinata 101', '022-6817120'),
	('PG003', 'Ayi M', 'Laki-Laki', 'Jl. Cibereum 11', '022-6192196'),
	('PG004', 'Ebenezer H', 'Laki-Laki', 'Jl. Cimindi 99', '022-6123890'),
	('PG005', 'Didik P', 'Laki-Laki', 'Jl. Dago 12', '022-6018287'),
	('PG006', 'Paina', 'Laki-Laki', 'Jl. Lembang 205', '022-6125962'),
	('PG007', 'Ody S', 'Laki-Laki', 'Jl. Sarimanis 14', '022-6001572'),
	('PG008', 'Iva S', 'Perempuan', 'Jl. Setraduta 21', '022-6162912');
/*!40000 ALTER TABLE `pengajar` ENABLE KEYS */;

-- Dumping structure for table db_kursus.peserta
CREATE TABLE IF NOT EXISTS `peserta` (
  `kodePeserta` char(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `namaPeserta` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `jkPeserta` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `alamatPeserta` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `teleponPeserta` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`kodePeserta`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table db_kursus.peserta: ~9 rows (approximately)
/*!40000 ALTER TABLE `peserta` DISABLE KEYS */;
INSERT INTO `peserta` (`kodePeserta`, `namaPeserta`, `jkPeserta`, `alamatPeserta`, `teleponPeserta`) VALUES
	('PS001', 'Natalia K', 'Perempuan', 'Jl. Otista 28', '022-6271927'),
	('PS002', 'Lydia K', 'Perempuan', 'Jl. ABC 101', '022-6810271'),
	('PS003', 'Yoelius W', 'Laki-Laki', 'Jl. Djundjunan 5', '022-6910020'),
	('PS004', 'Adi T', 'Laki-Laki', 'Jl. Rajawali 201', '022-6089012'),
	('PS005', 'Leonard H', 'Laki-Laki', 'Jl. Cihampelas 22', '022-6182009'),
	('PS006', 'Titing S', 'Perempuan', 'Jl. Gatot Subroto 299', '022-6001295'),
	('PS007', 'Rini S', 'Perempuan', 'Jl. Karapitan 131', '022-6009921'),
	('PS008', 'Desy D', 'Perempuan', 'Jl. Sangkuriang 10', '022-6019700'),
	('PS009', 'Ghina V', 'Perempuan', 'Jl. Magenta 19', '022-6012712');
/*!40000 ALTER TABLE `peserta` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
