package com.project.buku.Database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppRoomDB_Impl extends AppRoomDB {
  private volatile BukuDao _bukuDao;

  private volatile PembeliDao _pembeliDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `buku` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `namabuku` TEXT NOT NULL, `jumlah` INTEGER NOT NULL, `harga` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `pembeli` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nama` TEXT NOT NULL, `nohp` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '033cebdbada360ba1d425c964d46553a')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `buku`");
        _db.execSQL("DROP TABLE IF EXISTS `pembeli`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBuku = new HashMap<String, TableInfo.Column>(4);
        _columnsBuku.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuku.put("namabuku", new TableInfo.Column("namabuku", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuku.put("jumlah", new TableInfo.Column("jumlah", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuku.put("harga", new TableInfo.Column("harga", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBuku = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBuku = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBuku = new TableInfo("buku", _columnsBuku, _foreignKeysBuku, _indicesBuku);
        final TableInfo _existingBuku = TableInfo.read(_db, "buku");
        if (! _infoBuku.equals(_existingBuku)) {
          return new RoomOpenHelper.ValidationResult(false, "buku(com.project.buku.Database.Buku).\n"
                  + " Expected:\n" + _infoBuku + "\n"
                  + " Found:\n" + _existingBuku);
        }
        final HashMap<String, TableInfo.Column> _columnsPembeli = new HashMap<String, TableInfo.Column>(3);
        _columnsPembeli.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPembeli.put("nama", new TableInfo.Column("nama", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPembeli.put("nohp", new TableInfo.Column("nohp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPembeli = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPembeli = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPembeli = new TableInfo("pembeli", _columnsPembeli, _foreignKeysPembeli, _indicesPembeli);
        final TableInfo _existingPembeli = TableInfo.read(_db, "pembeli");
        if (! _infoPembeli.equals(_existingPembeli)) {
          return new RoomOpenHelper.ValidationResult(false, "pembeli(com.project.buku.Database.Pembeli).\n"
                  + " Expected:\n" + _infoPembeli + "\n"
                  + " Found:\n" + _existingPembeli);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "033cebdbada360ba1d425c964d46553a", "6c169ec5e89bf07a439a6832914ada07");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "buku","pembeli");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `buku`");
      _db.execSQL("DELETE FROM `pembeli`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public BukuDao bukuDao() {
    if (_bukuDao != null) {
      return _bukuDao;
    } else {
      synchronized(this) {
        if(_bukuDao == null) {
          _bukuDao = new BukuDao_Impl(this);
        }
        return _bukuDao;
      }
    }
  }

  @Override
  public PembeliDao pembeliDao() {
    if (_pembeliDao != null) {
      return _pembeliDao;
    } else {
      synchronized(this) {
        if(_pembeliDao == null) {
          _pembeliDao = new PembeliDao_Impl(this);
        }
        return _pembeliDao;
      }
    }
  }
}
