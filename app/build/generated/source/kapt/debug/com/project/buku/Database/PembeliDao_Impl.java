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
public final class PembeliDao_Impl implements PembeliDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Pembeli> __insertionAdapterOfPembeli;

  private final EntityDeletionOrUpdateAdapter<Pembeli> __deletionAdapterOfPembeli;

  private final EntityDeletionOrUpdateAdapter<Pembeli> __updateAdapterOfPembeli;

  public PembeliDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPembeli = new EntityInsertionAdapter<Pembeli>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `pembeli` (`id`,`nama`,`nohp`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pembeli value) {
        stmt.bindLong(1, value.getId());
        if (value.getNama() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama());
        }
        if (value.getNohp() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNohp());
        }
      }
    };
    this.__deletionAdapterOfPembeli = new EntityDeletionOrUpdateAdapter<Pembeli>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `pembeli` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pembeli value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPembeli = new EntityDeletionOrUpdateAdapter<Pembeli>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `pembeli` SET `id` = ?,`nama` = ?,`nohp` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pembeli value) {
        stmt.bindLong(1, value.getId());
        if (value.getNama() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama());
        }
        if (value.getNohp() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNohp());
        }
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public Object addPembeli(final Pembeli pembeli, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPembeli.insert(pembeli);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deletePembeli(final Pembeli pembeli, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPembeli.handle(pembeli);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updatePembeli(final Pembeli pembeli, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPembeli.handle(pembeli);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAllPembeli(final Continuation<? super List<Pembeli>> p0) {
    final String _sql = "SELECT * FROM pembeli";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Pembeli>>() {
      @Override
      public List<Pembeli> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
          final int _cursorIndexOfNohp = CursorUtil.getColumnIndexOrThrow(_cursor, "nohp");
          final List<Pembeli> _result = new ArrayList<Pembeli>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Pembeli _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNama;
            _tmpNama = _cursor.getString(_cursorIndexOfNama);
            final String _tmpNohp;
            _tmpNohp = _cursor.getString(_cursorIndexOfNohp);
            _item = new Pembeli(_tmpId,_tmpNama,_tmpNohp);
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
  public Object getPembeli(final int pembeli_id, final Continuation<? super List<Pembeli>> p1) {
    final String _sql = "SELECT * FROM pembeli WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pembeli_id);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Pembeli>>() {
      @Override
      public List<Pembeli> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
          final int _cursorIndexOfNohp = CursorUtil.getColumnIndexOrThrow(_cursor, "nohp");
          final List<Pembeli> _result = new ArrayList<Pembeli>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Pembeli _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNama;
            _tmpNama = _cursor.getString(_cursorIndexOfNama);
            final String _tmpNohp;
            _tmpNohp = _cursor.getString(_cursorIndexOfNohp);
            _item = new Pembeli(_tmpId,_tmpNama,_tmpNohp);
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
