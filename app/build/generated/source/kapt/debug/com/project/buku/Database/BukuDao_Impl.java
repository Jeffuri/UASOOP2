package com.project.buku.Database;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BukuDao_Impl implements BukuDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Buku> __insertionAdapterOfBuku;

  private final EntityDeletionOrUpdateAdapter<Buku> __deletionAdapterOfBuku;

  private final EntityDeletionOrUpdateAdapter<Buku> __updateAdapterOfBuku;

  public BukuDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBuku = new EntityInsertionAdapter<Buku>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `buku` (`id`,`namabuku`,`jumlah`,`harga`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Buku value) {
        stmt.bindLong(1, value.getId());
        if (value.getNamabuku() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNamabuku());
        }
        stmt.bindLong(3, value.getJumlah());
        stmt.bindLong(4, value.getHarga());
      }
    };
    this.__deletionAdapterOfBuku = new EntityDeletionOrUpdateAdapter<Buku>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `buku` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Buku value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfBuku = new EntityDeletionOrUpdateAdapter<Buku>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `buku` SET `id` = ?,`namabuku` = ?,`jumlah` = ?,`harga` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Buku value) {
        stmt.bindLong(1, value.getId());
        if (value.getNamabuku() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNamabuku());
        }
        stmt.bindLong(3, value.getJumlah());
        stmt.bindLong(4, value.getHarga());
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public Object addBuku(final Buku buku, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBuku.insert(buku);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteBuku(final Buku buku, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfBuku.handle(buku);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateBuku(final Buku buku, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfBuku.handle(buku);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAllBuku(final Continuation<? super List<Buku>> p0) {
    final String _sql = "SELECT * FROM buku";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Buku>>() {
      @Override
      public List<Buku> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNamabuku = CursorUtil.getColumnIndexOrThrow(_cursor, "namabuku");
          final int _cursorIndexOfJumlah = CursorUtil.getColumnIndexOrThrow(_cursor, "jumlah");
          final int _cursorIndexOfHarga = CursorUtil.getColumnIndexOrThrow(_cursor, "harga");
          final List<Buku> _result = new ArrayList<Buku>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Buku _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNamabuku;
            _tmpNamabuku = _cursor.getString(_cursorIndexOfNamabuku);
            final int _tmpJumlah;
            _tmpJumlah = _cursor.getInt(_cursorIndexOfJumlah);
            final int _tmpHarga;
            _tmpHarga = _cursor.getInt(_cursorIndexOfHarga);
            _item = new Buku(_tmpId,_tmpNamabuku,_tmpJumlah,_tmpHarga);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getBuku(final int buku_id, final Continuation<? super List<Buku>> p1) {
    final String _sql = "SELECT * FROM buku WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, buku_id);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Buku>>() {
      @Override
      public List<Buku> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNamabuku = CursorUtil.getColumnIndexOrThrow(_cursor, "namabuku");
          final int _cursorIndexOfJumlah = CursorUtil.getColumnIndexOrThrow(_cursor, "jumlah");
          final int _cursorIndexOfHarga = CursorUtil.getColumnIndexOrThrow(_cursor, "harga");
          final List<Buku> _result = new ArrayList<Buku>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Buku _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNamabuku;
            _tmpNamabuku = _cursor.getString(_cursorIndexOfNamabuku);
            final int _tmpJumlah;
            _tmpJumlah = _cursor.getInt(_cursorIndexOfJumlah);
            final int _tmpHarga;
            _tmpHarga = _cursor.getInt(_cursorIndexOfHarga);
            _item = new Buku(_tmpId,_tmpNamabuku,_tmpJumlah,_tmpHarga);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }
}
