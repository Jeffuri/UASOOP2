package com.project.buku;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0010J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0010H\u0014J\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/project/buku/BukuActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "bukuAdapter", "Lcom/project/buku/BukuAdapter;", "getBukuAdapter", "()Lcom/project/buku/BukuAdapter;", "setBukuAdapter", "(Lcom/project/buku/BukuAdapter;)V", "db", "Lcom/project/buku/Database/AppRoomDB;", "getDb", "()Lcom/project/buku/Database/AppRoomDB;", "db$delegate", "Lkotlin/Lazy;", "deleteDialog", "", "buku", "Lcom/project/buku/Database/Buku;", "intentEdit", "bukuId", "", "intentType", "loadBuku", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setupListener", "setupRecyclerView", "app_debug"})
public final class BukuActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy db$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public com.project.buku.BukuAdapter bukuAdapter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.project.buku.Database.AppRoomDB getDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.project.buku.BukuAdapter getBukuAdapter() {
        return null;
    }
    
    public final void setBukuAdapter(@org.jetbrains.annotations.NotNull()
    com.project.buku.BukuAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    public final void loadBuku() {
    }
    
    public final void setupListener() {
    }
    
    public final void setupRecyclerView() {
    }
    
    public final void intentEdit(int bukuId, int intentType) {
    }
    
    private final void deleteDialog(com.project.buku.Database.Buku buku) {
    }
    
    public BukuActivity() {
        super();
    }
}