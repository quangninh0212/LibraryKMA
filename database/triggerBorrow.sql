DELIMITER $$
CREATE TRIGGER after_book_borrow
AFTER INSERT ON borrow
FOR EACH ROW
BEGIN
    UPDATE books
    SET soLuong = soLuong - 1
    WHERE maSach = NEW.maSach;
END $$
DELIMITER $$


DELIMITER $$
CREATE TRIGGER after_book_return
AFTER UPDATE ON borrow
FOR EACH ROW
BEGIN
    -- Chỉ thực hiện khi trạng thái thay đổi từ 1 (đang mượn) thành 0 (đã trả)
    IF OLD.tinhTrang = 1 AND NEW.tinhTrang = 0 THEN
        UPDATE books
        SET soLuong = soLuong + 1
        WHERE maSach = NEW.maSach;
    END IF;
END $$
DELIMITER ;